package menues;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utilidades.ImpresoraPantalla;
import contenedores.ListadoArticulos;
import contenedores.ListadoUsuarios;
import modelos.Articulo;
import modelos.Usuario;
import utilidades.ArchivadorGeneric;
import utilidades.ArticuloScanner;

public class MenuEmpleado extends MenuOperaciones implements IMenu 
{
	
	
	private Scanner sc;
	private Usuario usuarioLogueado;
	private ImpresoraPantalla impresoraPantalla = new ImpresoraPantalla();
	
	public MenuEmpleado(Scanner sc, Usuario usuarioLogueado) {
		super();
		this.sc = sc;
		this.usuarioLogueado = usuarioLogueado;
	}

	public void mostrarOpciones() {
		System.out.println("Elija una opcion");
		System.out.println("1-Cargar articulo");
		System.out.println("2-Editar articulo");
		System.out.println("3-Eliminar articulo");
		System.out.println("4-Mostrar articulos");
		System.out.println("0- Cerrar sesion");
	}

	@Override
	public void iniciar() 
	{
		String opcion = "";
		while (!opcion.equals("0")) 
		{
			mostrarOpciones();
			opcion = sc.next();
			
			switch (opcion) 
			{
				case "1":
					cargarArticulos();
					break;
				case "2":
					editarArticulo();
					break;
				case "3":
					eliminarArticulo();
					break;
				case "4":
					mostrarArticulos();
					break;
				case "0":
					break;
				default:
					System.out.println("La opcion ingresada no es valida");
					break;
			}
		}

	}
	
	private void mostrarArticulos()
	{
		this.mostrarArticulosEnTienda();
	}
	
	public void cargarArticulos()
	{
		Articulo articulo = ArticuloScanner.getArticulo(sc);
		
		ArchivadorGeneric<ListadoArticulos> archiLG = this.getArchivadorListadoArticulos();
		ListadoArticulos listadoArticulos = archiLG.leer();
		
		ListadoUsuarios.guardar();
		
		listadoArticulos.agregar(articulo);
		
		archiLG.guardar(listadoArticulos);
	}
	
	public void editarArticulo()
	{
		ArchivadorGeneric<ListadoArticulos> archiLG = this.getArchivadorListadoArticulos();
		ListadoArticulos listadoArticulos = archiLG.leer();
		
		List<Articulo> articulos = new ArrayList<>(listadoArticulos.getListado());
		if ( articulos.isEmpty() )
		{
			System.out.println("Sin Stock");
			return;
		}
		
		System.out.println("Introduce el codigo a editar");
		int codigoArticuloEditar = sc.nextInt();	
		
		System.out.println("Introduce el nuevo nombre");
		String nombreNuevo = sc.next();
		System.out.println("Introduce el nuevo precio");
		double precioNuevo = sc.nextDouble();
		
		for ( Articulo articulo : listadoArticulos.getListado() )
		{
			if ( articulo.getCodigo() == codigoArticuloEditar )
			{
				listadoArticulos.eliminar(codigoArticuloEditar);
				
				Articulo articuloEditado = new Articulo(codigoArticuloEditar, nombreNuevo, precioNuevo);
				
				listadoArticulos.agregar(articuloEditado);
				
				archiLG.guardar(listadoArticulos);
				
				break;
			}	
		}
	}
	
	public void eliminarArticulo()
	{
		ArchivadorGeneric<ListadoArticulos> archiLG = this.getArchivadorListadoArticulos();
		ListadoArticulos listadoArticulos = archiLG.leer();
		
		List<Articulo> articulos = new ArrayList<>(listadoArticulos.getListado());
		if ( articulos.isEmpty() )
		{
			System.out.println("Sin Stock");
			return;
		}
		
		System.out.println("Introduce el codigo de producto a eliminar");
		int codigoArticuloEliminar = sc.nextInt();
		
		for ( Articulo articulo : listadoArticulos.getListado() )
		{
			if ( articulo.getCodigo() == codigoArticuloEliminar )
			{
				ListadoUsuarios.guardar();
				
				listadoArticulos.eliminar(codigoArticuloEliminar);
				
				archiLG.guardar(listadoArticulos);
				
				break;
			}	
		}		
	}

}
