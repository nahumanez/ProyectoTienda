package menues;

import java.util.ArrayList;
import java.util.List;

import contenedores.ListadoArticulos;
import modelos.Articulo;
import utilidades.ArchivadorGeneric;
import utilidades.ImpresoraPantalla;

public class MenuOperaciones {

	private ImpresoraPantalla impresoraPantalla = new ImpresoraPantalla();
	
	public void mostrarArticulosEnTienda()
	{
		List<Articulo> articulos = new ArrayList<>(this.getArchivadorListadoArticulos().leer().getListado());
		if ( articulos.isEmpty() )
		{
			System.out.println("No hay Articulos");
			return;
		}
		
		impresoraPantalla.imprimirArticulos(articulos);	
	}

	public ArchivadorGeneric<ListadoArticulos> getArchivadorListadoArticulos()
	{
		String archivoGuiones = System.getProperty("archivo_articulos");
		return new ArchivadorGeneric<ListadoArticulos>(archivoGuiones);	
	}
}
