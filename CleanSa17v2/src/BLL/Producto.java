package BLL;

import java.util.LinkedList;

public class Producto {
	private String nombre;
	private int stock;
	private double precio;
	private int categoria;
	private int peligroso;
	private static LinkedList<Producto> producto = new LinkedList<Producto>() ;
	public Producto(String nombre, int stcok, double precio, int categoria, int peligroso) {
		super();
		this.nombre = nombre;
		this.stock = stcok;
		this.precio = precio;
		this.categoria = categoria;
		this.peligroso = peligroso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStcok() {
		return stock;
	}
	public void setStcok(int stcok) {
		this.stock = stcok;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getPeligroso() {
		return peligroso;
	}
	public void setPeligroso(int peligroso) {
		this.peligroso = peligroso;
	}
	public static LinkedList<Producto> getProducto() {
		return producto;
	}
	public static void setProducto(LinkedList<Producto> producto) {
		Producto.producto = producto;
	}
	@Override
	public String toString() {
		return "Producto Nombre: " + nombre + " Stcok: " + stock + " Precio:" + precio + " Categoria: " + categoria
				+ " Peligroso=" + peligroso;
	}
	
	

}
