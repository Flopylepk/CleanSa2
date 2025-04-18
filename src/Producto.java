

public class Producto {
	private String nombre;
	private int stcok;
	private double precio;
	private String categoria;
	private boolean peligroso;
	private LinkedList<Producto> producto;
	public Producto(String nombre, int stcok, double precio, String categoria, boolean peligroso) {
		super();
		this.nombre = nombre;
		this.stcok = stcok;
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
		return stcok;
	}
	public void setStcok(int stcok) {
		this.stcok = stcok;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isPeligroso() {
		return peligroso;
	}
	public void setPeligroso(boolean peligroso) {
		this.peligroso = peligroso;
	}
	public LinkedList<Producto> getProducto() {
		return producto;
	}
	public void setProducto(LinkedList<Producto> producto) {
		this.producto = producto;
	}
	
	

}
