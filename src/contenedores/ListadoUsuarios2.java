package contenedores;

import java.io.Serializable;
import java.util.HashMap;

import modelos.Usuario;
import utilidades.ArchivadorGeneric;

public class ListadoUsuarios2 implements 
Serializable,
Contenedor<String, Usuario>
{	
	private static final long serialVersionUID = -9070790341530944084L;
	
	private static ListadoUsuarios2 singletton;
		
	public static ListadoUsuarios2 getInstance() {
		return singletton;
	}
	
	public static void guardar() {
		String archivoUsuarios = System.getProperty("archivo_usuarios");		
		ArchivadorGeneric<ListadoUsuarios2> archiLU;
		archiLU = new ArchivadorGeneric<ListadoUsuarios2>(archivoUsuarios);
		
		archiLU.guardar(singletton);
	}
	
	
	public static void cargar() {
		
		//Levantar archivador
		String archivoUsuarios = System.getProperty("archivo_usuarios");		
		ArchivadorGeneric<ListadoUsuarios2> archiLU;
		archiLU = new ArchivadorGeneric<ListadoUsuarios2>(archivoUsuarios);
		
		//Decido si lo levanto o creo uno nuevo
		if(archiLU.existe()) {
			singletton = archiLU.leer();
		}else {
			singletton = new ListadoUsuarios2();
			archiLU.guardar(singletton);
		}
		
		
	}
	
	private ListadoUsuarios2() {
		this.usuarios = new HashMap<String, Usuario>();
	}
	
	
	
	//-------------------------------------------------
	
	
	

	private HashMap<String, Usuario> usuarios;

	@Override
	public void agregar(Usuario usuario) {
		
		usuarios.put(usuario.getUsername().toLowerCase(), usuario);
		
	}

	@Override
	public Usuario buscar(String username) {
		Usuario usuarioBuscado = this.usuarios.get(username.toLowerCase());		
		return usuarioBuscado;
	}

	@Override
	public boolean existe(String username) {
		return this.usuarios.containsKey(username.toLowerCase());
	}

	@Override
	public void eliminar(String username) {
		this.usuarios.remove(username.toLowerCase());
		
	}
	
	
	
	
	
	
	
}
