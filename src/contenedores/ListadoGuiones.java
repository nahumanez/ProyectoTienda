package contenedores;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import modelos.Articulo;

public class ListadoGuiones implements Contenedor<Integer, Articulo>,
Iterable<Articulo>,
Serializable
{

	private static final long serialVersionUID = 7027619683675200718L;
	
	private HashMap<Integer, Articulo> guiones;
	
	
	
	public ListadoGuiones() {
		super();
		this.guiones = new HashMap<Integer, Articulo>();
	}

	@Override
	public void agregar(Articulo guion) {
		this.guiones.put(guion.getCodigo(), guion);
		
	}

	@Override
	public Articulo buscar(Integer clave) {
		return this.guiones.get(clave);
	}

	@Override
	public boolean existe(Integer clave) {
		return this.guiones.containsKey(clave);
	}

	@Override
	public void eliminar(Integer clave) {
		this.guiones.remove(clave);
		
	}

	public int getCantidad() {
		return this.guiones.size();
	}

	@Override
	public Iterator<Articulo> iterator() {
		return this.guiones.values().iterator();
	}
	
	
	
	
}
