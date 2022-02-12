package modelos;

import java.io.Serializable;

public class Articulo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7027619683675200718L;
	
	private int codigo;
	private String nombre;
	private String precio;
	
	
	public Articulo(int codigo, String nombre, String precio)
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int codigo_Segunda_Variable) 
	{
		this.codigo = codigo_Segunda_Variable;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre_Segunda_Variable) 
	{
		this.nombre = nombre_Segunda_Variable;
	}
	public String getPrecio() 
	{
		return precio;
	}
	public void setPrecio(String precio_Segunda_Variable) 
	{
		this.precio = precio_Segunda_Variable;
	}
	
	public void mostrarArticulo()
	{
		System.out.println("Codigo: " + codigo);
		System.out.println("Nombre: " + nombre);
		System.out.println("Precio: " + precio);
	}
}
