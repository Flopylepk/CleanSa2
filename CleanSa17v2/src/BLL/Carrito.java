package BLL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

public class Carrito {
	
	private int id_carrito;
	private Date fecha;
	private Cliente cliente;
	private double total_compra;
	private String estado;
	private int codigo_envio;
	private int fk_cliente;
	public Carrito(int id_carrito,Date fecha2 ,double total_compra,
			int codigo_envio,int fk_cliente) {
		
		this.fecha = fecha2;
		this.total_compra = total_compra;
		this.codigo_envio = codigo_envio;
		this.id_carrito= id_carrito;
		this.fk_cliente=fk_cliente;
	}
	

	public Carrito() {
		super();
	}
	

		this.id_carrito= id_carrito;
	
	}
	public int getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(int id_carrito) {
		this.id_carrito = id_carrito;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public int getCodigo_envio() {
		return codigo_envio;
	}
	public void setCodigo_envio(int codigo_envio) {
		this.codigo_envio = codigo_envio;
	}


	public int getFk_cliente() {
		return fk_cliente;
	}


	public void setFk_cliente(int fk_cliente) {
		this.fk_cliente = fk_cliente;
	}


	@Override
	public String toString() {
		return "Carrito [id_carrito=" + id_carrito + ", fecha=" + fecha + ", cliente=" + cliente + ", total_compra="
				+ total_compra + ", estado=" + estado + ", codigo_envio=" + codigo_envio + ", fk_cliente=" + fk_cliente
				+ "]";
	}
	
	
	
	
	
	
	
}
