package modelos;

import java.io.Serializable;

public class Articulo implements Serializable
{
	private static final long serialVersionUID = 7027619683675200718L;
	
	private int codigo;
	private String nombre;
	private double precio;
	private int cantidad;
	
	public Articulo(int codigo, String nombre, double precio, int cantidad)
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
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
	public double getPrecio() 
	{
		return precio;
	}
	public void setPrecio(double precio_Segunda_Variable) 
	{
		this.precio = precio_Segunda_Variable;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
