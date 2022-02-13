package utilidades;

import java.util.List;

import modelos.Articulo;

public class ImpresoraPantalla 
{

	
	
    public void imprimirArticulos(List<Articulo> articulos)
    {
        for(Articulo articulo : articulos)
        {
            articulo.mostrarArticulo();
        }
    }
    
    public void imprimirPreciosArticulos(List<Articulo> preciosArticulos)
    {
    	double precioTotal = 0;
    	
        //for(Articulo precioArticulo : preciosArticulos)
        for(int i = 0; i < preciosArticulos.size(); i++)
    	{
            
            precioTotal += Double.parseDouble(preciosArticulos.get(i).toString());
            
            //precioArticulo.mostrarPrecioArticulo();
            
            System.out.println(precioTotal);         
        }
    }
}
