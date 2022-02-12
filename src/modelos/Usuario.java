package modelos;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -7445353332505395471L;
	
	private String username;
	private String password;
	private int tipoUsuario;
	private int puntos;
	
	public Usuario(String username, String password, int tipo) {
		super();
		this.username = username;
		this.password = password;
		this.tipoUsuario = tipo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validarPassword(String password) {
		return this.getPassword().equals(password);
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	
	
	public void addPuntos(int puntos) {
		this.puntos += puntos;
	}
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public boolean esCliente()
	{
		return tipoUsuario == 2;
	}
	
	public boolean esEmpleado()
	{
		return tipoUsuario == 1;
	}
}
