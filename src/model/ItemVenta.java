package model;

public class ItemVenta {
	private Producto producto;
	private int cantidad;
	private double precioUnitario;

	public ItemVenta(Producto producto, int cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioUnitario = producto.getPrecio();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String toString() {
		return "ItemVenta [producto=" + producto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario
				+ "]";
	}

}
