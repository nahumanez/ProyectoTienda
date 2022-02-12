package utilidades;

import java.util.Scanner;

import modelos.Articulo;

public class ArticuloScanner {

    public static Articulo getArticulo(Scanner scanner)
    {
		System.out.println("Introduce el codigo");
		int codigo_Tercera_Variable = scanner.nextInt();
		System.out.println("Introduce el nombre");
		String nombre_Tercera_Variable = scanner.next();
		System.out.println("introduce el precio");
		String precio_Tercera_Variable = scanner.next();

		return new Articulo(codigo_Tercera_Variable, nombre_Tercera_Variable, precio_Tercera_Variable);
    }
}
