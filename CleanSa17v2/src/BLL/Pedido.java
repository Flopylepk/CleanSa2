package BLL;

public class Pedido {
	private int fk_carrito;
	private int fk_producto;
	private int cantidad;
	private double totalPrecio;
	private int id_pedido;
	
	
	
	
	public Pedido(int fk_carrito, int fk_producto, int cantidad, double totalPrecio) {
		super();
		this.fk_carrito = fk_carrito;
		this.fk_producto = fk_producto;
		this.cantidad = cantidad;
		this.totalPrecio = totalPrecio;
	}
	public Pedido(int fk_carrito, int fk_producto, int cantidad, double totalPrecio, int id_pedido) {
		super();
		this.fk_carrito = fk_carrito;
		this.fk_producto = fk_producto;
		this.cantidad = cantidad;
		this.totalPrecio = totalPrecio;
		this.id_pedido = id_pedido;
	}

	public int getFk_carrito() {
		return fk_carrito;
	}

	public void setFk_carrito(int fk_carrito) {
		this.fk_carrito = fk_carrito;
	}

	public int getFk_producto() {
		return fk_producto;
	}
	public void setFk_producto(int fk_producto) {
		this.fk_producto = fk_producto;
	}


	
	public int getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public double getTotalPrecio() {
		return totalPrecio;
	}

	public void setTotalPrecio(double totalPrecio) {
		this.totalPrecio = totalPrecio;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Pedido [fk_carrito=" + fk_carrito + ", fk_producto=" + fk_producto + ", cantidad=" + cantidad
				+ ", totalPrecio=" + totalPrecio + "]";
	}

 
	
	
	
	
}
