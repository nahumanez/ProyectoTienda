package modelos;

import java.io.Serializable;

public class CuentaCredito implements Serializable{

	private static final long serialVersionUID = 8099982039725725730L;
	private boolean habilitada;
	private double saldo;
	private Usuario usuario;
	
	public void inhabilitar() {
		this.habilitada = false;
	}

	public CuentaCredito(Usuario usuario) {
		super();
		this.habilitada = false;
		this.saldo = 0;
		this.usuario = usuario;
	}

	public void habilitar() {
		this.habilitada = true;		
	}

	public boolean estaHabilita() {
		return this.habilitada;
	}

	public void agregarDinero(Double monto) {
		this.saldo += monto;
		
	}

	public double getSaldo() {
		return saldo;
	}

	public void transferir(double monto) {
		this.saldo -= monto;
		
	}
}
