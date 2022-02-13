package modelos;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = -7445353332505395471L;
	
	private String username;
	private String password;
	private int tipoUsuario;
	private CuentaCredito cuentaCredito;

	public Usuario(String username, String password, int tipo) {
		super();
		this.username = username;
		this.password = password;
		this.tipoUsuario = tipo;
		this.cuentaCredito = new CuentaCredito(this);
		this.cuentaCredito.inhabilitar();
	}

	public void crearCuentaCredito()
	{
		this.cuentaCredito.habilitar();
	}
	
	public boolean tieneCuenta() 
	{	
		return this.cuentaCredito.estaHabilita();
	}
	
	public CuentaCredito getCuentaCredito() {
		return cuentaCredito;
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
