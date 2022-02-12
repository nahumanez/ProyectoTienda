package contenedores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import modelos.Articulo;

public class ListadoArticulos implements Contenedor<Integer, Articulo>,
Iterable<Articulo>, Serializable
{
	private static final long serialVersionUID = -6886097702696546720L;
	
	private HashMap<Integer, Articulo> Articulos;
	
	public ListadoArticulos() {
		super();
		this.Articulos = new HashMap<Integer, Articulo>();
	}

	@Override
	public void agregar(Articulo Articulo) {
		this.Articulos.put(Articulo.getCodigo(), Articulo);
		
	}

	@Override
	public Articulo buscar(Integer clave) {
		return this.Articulos.get(clave);
	}

	@Override
	public boolean existe(Integer clave) {
		return this.Articulos.containsKey(clave);
	}

	@Override
	public void eliminar(Integer clave) {
		this.Articulos.remove(clave);
		
	}

	public int getCantidad() {
		return this.Articulos.size();
	}

	@Override
	public Iterator<Articulo> iterator() {
		return this.Articulos.values().iterator();
	}
	
	public List<Articulo> getListado() {
		
		if ( this.Articulos.isEmpty() )
		{
			return new ArrayList<Articulo>();
		}
		
		return new ArrayList<Articulo>(this.Articulos.values());
	}
	
}
