package BLL;
import java.time.LocalDate;
import java.util.LinkedList;

public class Carrito {
	
	private int id_carrito;
	private LocalDate fecha;
	private Cliente cliente;
	private double total_compra;
	private String estado;
	private boolean estado_envio;
	private int codigo_envio;
	public Carrito(int id_carrito,LocalDate fecha, String estado ,double total_compra , boolean estado_envio,
			int codigo_envio, Cliente cliente ) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.total_compra = total_compra;
		this.estado = estado;
		this.estado_envio = estado_envio;
		this.codigo_envio = codigo_envio;
		this.id_carrito= id_carrito;
	}
	
	
	public int getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
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
