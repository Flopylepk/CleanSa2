package BLL;
import java.time.LocalDate;
import java.util.LinkedList;

public class Carrito {

	private LocalDate fecha;
	private Cliente cliente;
	private  static LinkedList<Producto> productosC = new LinkedList<Producto>();
	private double total_compra;
	private String estado;
	private static LinkedList<Carrito> carrito = new LinkedList<Carrito>() ;
	private boolean estado_envio;
	private int codigo_envio;
	public Carrito(LocalDate fecha, Cliente cliente, double total_compra, String estado, boolean estado_envio,
			int codigo_envio) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.total_compra = total_compra;
		this.estado = estado;
		this.estado_envio = estado_envio;
		this.codigo_envio = codigo_envio;
	}
	
	public Carrito() {
		super();
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public static LinkedList<Producto> getProducto() {
		return productosC;
	}
	public static void setProducto(LinkedList<Producto> producto) {
		Carrito.productosC = producto;
	}
	public double getTotal_compra() {
		return total_compra;
	}
	public void setTotal_compra(double total_compra) {
		this.total_compra = total_compra;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public static LinkedList<Carrito> getCarrito() {
		return carrito;
	}
	public static void setCarrito(LinkedList<Carrito> carrito) {
		Carrito.carrito = carrito;
	}
	public boolean isEstado_envio() {
		return estado_envio;
	}
	public void setEstado_envio(boolean estado_envio) {
		this.estado_envio = estado_envio;
	}
	public int getCodigo_envio() {
		return codigo_envio;
	}
	public void setCodigo_envio(int codigo_envio) {
		this.codigo_envio = codigo_envio;
	}
	
	
	
	
	
}
