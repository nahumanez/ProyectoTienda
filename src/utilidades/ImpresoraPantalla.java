package utilidades;

import java.util.List;

import modelos.Articulo;

public class ImpresoraPantalla {

    public void imprimirArticulos(List<Articulo> articulos)
    {
        for(Articulo articulo : articulos)
        {
            articulo.mostrarArticulo();
        }
    }
}
