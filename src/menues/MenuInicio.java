package menues;

import java.util.Scanner;

import contenedores.ListadoUsuarios;
import modelos.Usuario;

public class MenuInicio implements IMenu {

	private Scanner sc;

	public MenuInicio(Scanner sc) {
		super();
		this.sc = sc;
	}

	public void mostrarOpciones() {
		System.out.println("Elija una opcion");
		System.out.println("1- Ingresar");
		System.out.println("2- Registrarse");
	}

	@Override
	public void iniciar() {
		String opcion = "";
		while (!opcion.equals("0")) {
			mostrarOpciones();
			opcion = sc.next();
			switch (opcion) {
			case "1":
				ingresar();
				break;
			case "2":
				registrarse();
				break;

			default:
				System.out.println("La opcion ingresada no es valida");
				break;
			}
		}

	}

	private void registrarse() {

		ListadoUsuarios listadoUsuarios = ListadoUsuarios.getInstance();
		
		System.out.println("Ingrese el nombre de usuario");

		String nombre = sc.next();
		if (!listadoUsuarios.existe(nombre)) 
		{	
			System.out.println("Ingrese la contrasenia del usuario");
			String contrasenia = sc.next();
			System.out.println("Ingrese tipo del usuario [1: Empleado 2: Cliente]");
			int tipo = sc.nextInt();
			
			Usuario usuarioNuevo = new Usuario(nombre, contrasenia, tipo);
			
			listadoUsuarios.agregar(usuarioNuevo);
			
			ListadoUsuarios.guardar();
			
		}else {
			System.out.println("El usuario ya existe");
		}
	}

	private void ingresar() {

		ListadoUsuarios listadoUsuarios = ListadoUsuarios.getInstance();

		System.out.println("Ingrese el nombre de usuario");
		String nombre = sc.next();
		if (listadoUsuarios.existe(nombre)) {

			System.out.println("Ingrese la contrasenia del usuario");
			String contrasenia = sc.next();

			Usuario usuario = listadoUsuarios.buscar(nombre);

			if (usuario.validarPassword(contrasenia)) 
			{
				if ( usuario.esEmpleado() )
				{
					IMenu menuEmpleado = new MenuEmpleado(sc, usuario);
					menuEmpleado.iniciar();
				} else if ( usuario.esCliente() )
				{
					IMenu menuCliente = new MenuCliente(sc, usuario);
					menuCliente.iniciar();
				}else {
					System.out.println("Usuario que tiene tipo invalido");
				}
	
			} else {
				System.out.println("La contrasenia es incorrecta");
			}

		} else {
			System.out.println("El usuario no existe");
		}

	}

}
