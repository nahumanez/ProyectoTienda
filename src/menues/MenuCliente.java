package menues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import contenedores.ListadoArticulos;
import modelos.Articulo;
import modelos.Usuario;
import utilidades.ArchivadorGeneric;
import utilidades.ImpresoraPantalla;

public class MenuCliente extends MenuOperaciones implements IMenu {

	private Scanner sc;
	private Usuario usuarioLogueado;
	private ImpresoraPantalla impresoraPantalla = new ImpresoraPantalla();
	private ArrayList<Articulo> articulosEnCarrito = new ArrayList<Articulo>();
	
	public MenuCliente(Scanner sc, Usuario usuarioLogueado) {
		super();
		this.sc = sc;
		this.usuarioLogueado = usuarioLogueado;
	}

	public void mostrarOpciones() {
		System.out.println("Elija una opcion");
		System.out.println("1-Ver productos");
		System.out.println("2-Cargar carrito");
		System.out.println("3-Ver carrito");
		System.out.println("4-Ver Costo Total carrito");
		System.out.println("5-Generar Factura");
		System.out.println("6-Comprar");
		System.out.println("0-Cerrar Session");
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
					
				default:
					System.out.println("La opcion ingresada no es valida");
					break;
			}
		}

	}
	
	private void comprar() {
		System.out.println("falta implementar el metodo comprar");
	}

	private void generarFactura() {
		System.out.println("falta implementar el metodo generarFactura");
		
	}

	private void verCostoTotalCarrito() {
		System.out.println("falta implementar el metodo verCostoTotalCarrito");
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
		
		for ( Articulo articulo : listadoArticulos.getListado() )
		{
			if ( articulo.getCodigo() == codigoArticulo )
			{
				Articulo articuloBuscado = listadoArticulos.buscar(codigoArticulo);
				
				articulosEnCarrito.add(articuloBuscado);
				
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
		impresoraPantalla.imprimirArticulos(articulosEnCarrito);	
	}

}
