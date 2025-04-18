import java.time.LocalDate;

public class Carrito {

	private LocalDate fecha;
	private Cliente cliente;
	private LinkedList<Productos> producto;
	private double total_compra;
	private String estado;
	private LinkedList<Carrtito> carrito;
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
	public LinkedList<Productos> getProducto() {
		return producto;
	}
	public void setProducto(LinkedList<Productos> producto) {
		this.producto = producto;
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
	public LinkedList<Carrtito> getCarrito() {
		return carrito;
	}
	public void setCarrito(LinkedList<Carrtito> carrito) {
		this.carrito = carrito;
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
