package menues;

import java.util.Scanner;

import modelos.Usuario;

public class MenuCreditos implements IMenu 
{
	private Scanner sc;
	private Usuario usuarioLogueado;
	
	public MenuCreditos(Scanner sc, Usuario usuarioLogueado) {
		super();
		this.sc = sc;
		this.usuarioLogueado = usuarioLogueado;
	}

	public void mostrarOpciones() 
	{
		System.out.println("Elija una opcion");
		System.out.println("1-Ver saldo");
		System.out.println("2-Agregar dinero");
		System.out.println("3-Remover cuenta de credito");
		System.out.println("0-Salir");
	}

	@Override
	public void iniciar() {
		String opcion = "";
		while (!opcion.equals("0")) 
		{
			mostrarOpciones();
			opcion = sc.next();
			switch (opcion) 
			{
				case "1":
					verSaldo();
					break;
				case "2":
					agregarDinero();
					break;
				case "3":
					removerCuentaCredito();
					opcion = "0";
					break;
				case "0":
					break;	
				default:
					System.out.println("La opcion ingresada no es valida");
					break;
			}
		}
	}
	
	private void verSaldo()
	{
		System.out.println("El saldo es: " + this.usuarioLogueado.getCuentaCredito().getSaldo());
	}
	
	private void agregarDinero()
	{
		System.out.println("Ingrese monto del dinero a ingresar");
		Double monto = sc.nextDouble();
		this.usuarioLogueado.getCuentaCredito().agregarDinero(monto);
	}
	
	private void removerCuentaCredito() {
		this.usuarioLogueado.getCuentaCredito().inhabilitar();
		System.out.println("Cuenta de credito removida");
		
	}

}
