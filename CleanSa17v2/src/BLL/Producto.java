package BLL;


import java.util.LinkedList;

import javax.swing.JOptionPane;

import repositorio.Validador;

public class Producto implements Validador{
	private String nombre;
	private int stock;
	private double precio;
	private int categoria;
	private boolean peligroso;
	private static LinkedList<Producto> producto = new LinkedList<Producto>() ;
	public Producto(String nombre, int stcok, double precio, int categoria, boolean peligroso) {
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
	public boolean getPeligroso() {
		return peligroso;
	}
	public void setPeligroso(boolean peligroso) {
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
	
	public static boolean AgregarProductos(Producto nuevo) {
		String nombre = nuevo.validarCaracteres("Ingrese nombre del producto: ");
		for (Producto p : producto) {
			if (p.getNombre().equals(nuevo.getNombre())) {
				JOptionPane.showMessageDialog(null, "No se puede agregar. El producto ya existe.");
				return false;	
			}
		}
		int stock = nuevo.validarNumeros("Ingrese stock del prodcuto: ");
		double precio = nuevo.validarPrecio("Ingrese el precio: ");
		int respuesta = JOptionPane.showConfirmDialog(
			    null,
			    "¿Querés continuar?",
			    "Confirmación",
			    JOptionPane.YES_NO_OPTION
			);

		boolean peligorso = (respuesta == JOptionPane.YES_OPTION);
		
		
		nuevo.setNombre(nombre);
		nuevo.setStcok(stock);
		nuevo.setPrecio(precio);
		nuevo.setPeligroso(peligorso);
		JOptionPane.showMessageDialog(null, nuevo.getNombre() + " agregado con exito.");
		producto.add(nuevo);
		return true;	
		
		
	}
	
	

}
