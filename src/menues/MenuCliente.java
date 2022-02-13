package menues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contenedores.ListadoArticulos;
import modelos.Articulo;
import modelos.ArticuloCarrito;
import modelos.Usuario;
import utilidades.ArchivadorGeneric;
import utilidades.ImpresoraPantalla;

public class MenuCliente extends MenuOperaciones implements IMenu 
{
	private Scanner sc;
	private Usuario usuarioLogueado;
	private ImpresoraPantalla impresoraPantalla = new ImpresoraPantalla();
	private ArrayList<ArticuloCarrito> articulosEnCarrito = new ArrayList<ArticuloCarrito>();
	
	public MenuCliente(Scanner sc, Usuario usuarioLogueado) {
		super();
		this.sc = sc;
		this.usuarioLogueado = usuarioLogueado;
	}

	public void mostrarOpciones() 
	{
		System.out.println("Elija una opcion");
		System.out.println("1-Ver productos");
		System.out.println("2-Cargar carrito");
		System.out.println("3-Ver carrito");
		System.out.println("4-Ver Costo Total carrito");
		System.out.println("5-Generar Factura");
		System.out.println("6-Comprar");
		
		if (this.usuarioLogueado.tieneCuenta())
		{
			System.out.println("7-Seccion Creditos");
		} else
		{
			System.out.println("7-Crear Cuenta Creditos");	
		}
		
		System.out.println("0-Salir");
	}

	@Override
	public void iniciar() {
		String opcion = "";
		while (!opcion.equals("0")) 
		{
			mostrarOpciones();
			opcion = sc.next();
			switch (opcion) 
			{
				case "1":
					mostrarArticulosEnStock();
					break;
				case "2":
					cargarCarrito();
					break;
				case "3":
					mostrarArticulosEnCarrito();
					break;
				case "4":
					verCostoTotalCarrito();
					break;
				case "5":
					generarFactura();
					break;
				case "6":
					comprar();
					break;
				case "7":
					if (this.usuarioLogueado.tieneCuenta())
					{
						IMenu menuCreditos = new MenuCreditos(sc, usuarioLogueado);
						menuCreditos.iniciar();					
					} else {
						crearCuentaCredito();	
					}
					break;
				case "0":
					break;
				default:
					System.out.println("La opcion ingresada no es valida");
					break;
			}
		}

	}
	
	private void crearCuentaCredito() {
		
		this.usuarioLogueado.crearCuentaCredito();
		System.out.println("Cuenta Credito creada!");
	}

	private void comprar() 
	{
		if ( articulosEnCarrito.isEmpty() )
		{
			System.out.println("Carrito Vacio");
			return;
		}
		
		ArchivadorGeneric<ListadoArticulos> archiLG = this.getArchivadorListadoArticulos();
		ListadoArticulos listadoArticulos = archiLG.leer();
		ArrayList<ArticuloCarrito> articulosPagar = new ArrayList<ArticuloCarrito>();
		
		for ( ArticuloCarrito articuloCarrito : articulosEnCarrito )
		{
			Articulo articuloEditar = listadoArticulos.buscar(articuloCarrito.getArticulo().getCodigo());
			
			// TODO validar que el articulo a editar no tenga una cantidad negativa
			
			int nuevaCantidad = articuloEditar.getCantidad() - articuloCarrito.getCantidad();

			if ( nuevaCantidad >= 0)
			{
				articulosPagar.add(articuloCarrito);
				
			} else
			{
				System.out.println("Codigo Articulo " +articuloEditar.getCodigo()+ " sin stock en la cantidad solicitada");
			}
		}
		
		articulosEnCarrito.clear();

		if ( articulosPagar.isEmpty() )
		{
			System.out.println("Carrito con articulos de stock insuficiente");
		} else
		{
			// TODO tranferir dinero de la cuenta de cliente hacia la cuenta destino
			
			double precioTotalCarrito = 0;
			
			for ( ArticuloCarrito unArticulo : articulosPagar )
			{
				precioTotalCarrito += unArticulo.getPrecioPorCantidad();
			}
			
			boolean saldoSuficiente = true;
			if ( this.usuarioLogueado.getCuentaCredito().estaHabilita() )
			{
				if ( this.usuarioLogueado.getCuentaCredito().getSaldo() >= precioTotalCarrito  )
				{				
					this.usuarioLogueado.getCuentaCredito().transferir(precioTotalCarrito);
					
				} else {
					saldoSuficiente = false;
				}
			}
			
			if (saldoSuficiente)
			{			
				for ( ArticuloCarrito unArticulo : articulosPagar )
				{
					Articulo articuloEditar = listadoArticulos.buscar(unArticulo.getArticulo().getCodigo());
					
					int nuevaCantidad = articuloEditar.getCantidad() - unArticulo.getCantidad();
					
					listadoArticulos.eliminar(unArticulo.getArticulo().getCodigo());
					
					Articulo articuloActualizado = new Articulo(unArticulo.getArticulo().getCodigo(), 
							unArticulo.getArticulo().getNombre(), 
							unArticulo.getArticulo().getPrecio(), nuevaCantidad);
					
					listadoArticulos.agregar(articuloActualizado);
					
					archiLG.guardar(listadoArticulos);
				}
							
				System.out.println("Compra realizada con exito!!!");
			} else {
				System.out.println("Saldo insuficiente para la compra");
			}
			
			impresoraPantalla.imprimirFacturaDe(articulosPagar);	
			
		}		
	}

	private void generarFactura() {
		
		if ( articulosEnCarrito.isEmpty() )
		{
			System.out.println("Carrito Vacio");
			return;
		}
		
		impresoraPantalla.imprimirFacturaDe(articulosEnCarrito);			
	}

	private void verCostoTotalCarrito() 
	{
		double precioTotal = 0;
		
		for ( ArticuloCarrito unArticulo : articulosEnCarrito )
		{
			precioTotal += unArticulo.getPrecioPorCantidad();
		}
		
		System.out.println("Precio Total del Carrito es: "+ precioTotal);
	}

	private void mostrarArticulosEnStock()
	{
		this.mostrarArticulosEnTienda();
	}
	
	private void cargarCarrito()
	{	
		ArchivadorGeneric<ListadoArticulos> archiLG = this.getArchivadorListadoArticulos();
		ListadoArticulos listadoArticulos = archiLG.leer();
		
		List<Articulo> articulos = new ArrayList<>(listadoArticulos.getListado());
		if ( articulos.isEmpty() )
		{
			System.out.println("Sin Stock");
			return;
		}

		System.out.println("Introduce el codigo de Articulo");
		int codigoArticulo = sc.nextInt();
		System.out.println("Introduce la Cantidad");
		int cantidadDelArticulo = sc.nextInt();
		
		for ( Articulo articulo : listadoArticulos.getListado() )
		{
			if ( articulo.getCodigo() == codigoArticulo )
			{
				if ( (articulo.getCantidad() - cantidadDelArticulo ) < 0 )
				{
					System.out.println("Articulo sin stock");
				} 
				else 
				{
					Articulo articuloBuscado = listadoArticulos.buscar(codigoArticulo);
					
					ArticuloCarrito articuloCarrito = new ArticuloCarrito(articuloBuscado, cantidadDelArticulo);
					
					articulosEnCarrito.add(articuloCarrito);
				}
				
				break;
			}	
		}
	}
	
	private void mostrarArticulosEnCarrito()
	{
		if ( articulosEnCarrito.isEmpty() )
		{
			System.out.println("Carrito Vacio");
			return;
		}
		impresoraPantalla.imprimirArticulosCarrito(articulosEnCarrito);	
	}

}
