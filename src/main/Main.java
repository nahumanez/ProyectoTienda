package main;

import java.util.Scanner;

import contenedores.ListadoArticulos;
import contenedores.ListadoUsuarios;
import menues.IMenu;
import menues.MenuInicio;
import utilidades.Archivador;

public class Main {

	public static void main(String[] args) {
		//Clase main
		//Nombres Archivos
		String archivoUsuarios =  "usuarios.txt";				
		System.setProperty("archivo_usuarios", archivoUsuarios);	
		
		String archivoArticulos =  "articulos.txt";				
		System.setProperty("archivo_articulos", archivoArticulos);	
		
		//Preparar Archivos
		Archivador archi = new Archivador();
		ListadoUsuarios.cargar();
		
		if(!archi.existe(archivoArticulos)) 
		{
			ListadoArticulos listadoArticulos = new ListadoArticulos();
			archi.guardar(archivoArticulos, listadoArticulos);
		}
		
		Archivador archi2 = new Archivador();
		ListadoUsuarios.cargar();
		
		if(!archi2.existe(archivoArticulos)) 
		{
			ListadoArticulos listadoArticulos = new ListadoArticulos();
			archi2.guardar(archivoArticulos, listadoArticulos);
		}
		
		
		//Preparar dependencias
		Scanner sc = new Scanner(System.in);
		
		
		//Iniciar programa
		IMenu menuInicio = new MenuInicio(sc);
		menuInicio.iniciar();	

	}

}
