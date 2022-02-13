package modelos;

public class ArticuloCarrito {

	private Articulo articulo;
	private int cantidad;

	public ArticuloCarrito(Articulo articulo, int cantidadDelArticulo) {
		this.articulo = articulo;
		this.cantidad = cantidadDelArticulo;
	}

	public double getPrecioPorCantidad() {
		return this.articulo.getPrecio() * this.cantidad;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
