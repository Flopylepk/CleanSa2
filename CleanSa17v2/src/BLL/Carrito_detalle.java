package BLL;

public class Carrito_detalle {
	
	private int id_carrito_detalle;
	private int fk_carrito;
	private int fk_producto;
	private double total_producto;
	private int cantidad;
	public Carrito_detalle(int id_carrito_detalle, int fk_carrito, int fk_producto, double total_producto,
			int cantidad) {
		super();
		this.id_carrito_detalle = id_carrito_detalle;
		this.fk_carrito = fk_carrito;
		this.fk_producto = fk_producto;
		this.total_producto = total_producto;
		this.cantidad = cantidad;
	}
	public int getId_carrito_detalle() {
		return id_carrito_detalle;
	}
	public void setId_carrito_detalle(int id_carrito_detalle) {
		this.id_carrito_detalle = id_carrito_detalle;
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
	public double getTotal_producto() {
		return total_producto;
	}
	public void setTotal_producto(double total_producto) {
		this.total_producto = total_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Carrito_detalle [id_carrito_detalle=" + id_carrito_detalle + ", fk_carrito=" + fk_carrito
				+ ", fk_producto=" + fk_producto + ", total_producto=" + total_producto + ", cantidad=" + cantidad
				+ "]";
	}
	
	

}
