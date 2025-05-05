package BLL;
import java.time.LocalDate;
import java.util.LinkedList;

public class Camion {
	private String matricula;
	private Carrito carrito;
	private LocalDate fecha_entrega;
	private LinkedList<Camion> camiones;
	public Camion(String matricula, Carrito carrito, LocalDate fecha_entrega) {
		super();
		this.matricula = matricula;
		this.carrito = carrito;
		this.fecha_entrega = fecha_entrega;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	public LocalDate getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(LocalDate fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public LinkedList<Camion> getCamiones() {
		return camiones;
	}
	public void setCamiones(LinkedList<Camion> camiones) {
		this.camiones = camiones;
	}
	

}
