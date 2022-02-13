package utilidades;

import java.util.ArrayList;
import java.util.List;

import modelos.Articulo;
import modelos.ArticuloCarrito;

public class ImpresoraPantalla 
{

    public void imprimirArticulos(List<Articulo> articulos)
    {
        for(Articulo articulo : articulos)
        {
    		System.out.print("[Codigo: " + articulo.getCodigo() + "; ");
    		System.out.print("Nombre: " + articulo.getNombre()+ "; ");
    		System.out.print("Precio: " + articulo.getPrecio()+ "; ");
    		System.out.println("Cantidad: " + articulo.getCantidad()+ "]");
        }
    }
    
    public void imprimirArticulosCarrito(List<ArticuloCarrito> articulosCarrito)
    {
        for(ArticuloCarrito articuloCarrito : articulosCarrito)
        {
    		System.out.print("[Codigo: " + articuloCarrito.getArticulo().getCodigo() + "; ");
    		System.out.print("Nombre: " + articuloCarrito.getArticulo().getNombre() + "; ");
    		System.out.print("Precio: " + articuloCarrito.getArticulo().getPrecio() + "; ");
    		System.out.println("Cantidad: " + articuloCarrito.getCantidad() + "]");
        }
    }

	public void imprimirFacturaDe(ArrayList<ArticuloCarrito> articulosEnCarrito) {
		
		double precioTotal = 0;
		
		for ( ArticuloCarrito unArticulo : articulosEnCarrito )
		{
			precioTotal += unArticulo.getPrecioPorCantidad();
		}
		
		System.out.println("Cantidad | Codigo | Nombre | Precio Unitario | Total");
		
        for(ArticuloCarrito articuloCarrito : articulosEnCarrito)
        {
    		System.out.print(articuloCarrito.getCantidad() + " | ");
    		System.out.print(articuloCarrito.getArticulo().getCodigo() + " | ");
    		System.out.print(articuloCarrito.getArticulo().getNombre() + " | ");
    		System.out.print(articuloCarrito.getArticulo().getPrecio() + " | ");
    		System.out.println(articuloCarrito.getCantidad() * articuloCarrito.getArticulo().getPrecio());
        }
        
        System.out.println(" ------------------------- Total " + precioTotal);
	}
}
