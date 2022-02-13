package utilidades;

import java.util.Scanner;

import modelos.Articulo;

public class ArticuloScanner {

    public static Articulo getArticulo(Scanner scanner)
    {
    	int limiteBucle = 4;
    	int i = 0;
    	int cod = 0;
    	double precio = 0;
    	int cantidad = 0;
    	String nombre = "";
    	
    	boolean esArticuloValido = true;
    	while ( esArticuloValido )
    	{
    		i++;
    		esArticuloValido = i < limiteBucle;
			System.out.println("Introduce el codigo numerico");
			String codString = scanner.next();
			
			try {
				cod = Integer.parseInt(codString);
			} catch (Exception e) {
				System.out.println("El codigo debe ser numerico");
				continue;
			}
			
			System.out.println("Introduce el nombre");
			nombre = scanner.next();
			
			System.out.println("Introducir un precio numerico");		
			String precioString = scanner.next();
			
			try {
				precio = Double.parseDouble(precioString);
			} catch (Exception e) {
				System.out.println("El precio debe ser numerico");
				continue;
			}
			
			System.out.println("Introducir la Cantidad en stock");		
			String cantidadString = scanner.next();
			
			try {
				cantidad = Integer.parseInt(cantidadString);
			} catch (Exception e) {
				System.out.println("La cantidad debe ser numerico");
				continue;
			}
			
			break;
    	}
    	
    	if ( esArticuloValido )
    	{
    		return  new Articulo(cod, nombre, precio, cantidad);
    	}else
    	{
    		return null;
    	}
    }
}
