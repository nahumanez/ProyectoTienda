package contenedores;

public interface Contenedor <K,V>{

	//ABM
	public void agregar(V v);
	public V buscar(K clave);
	public boolean existe(K clave);
	public void eliminar(K clave);
}
