package BLL;

import repositorio.Validador;

public class Administrador implements Validador {
	
	private String nombre;
	private String apellido;
	private int id;
	private int tipo;
	private String contrasena;
	
	public Administrador(String nombre, String apellido, int id, int tipo, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.id=id;
		this.tipo=tipo;
		this.contrasena=contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean LogIn (String usuario, String contrasena) {
		
		return false;
	}
	
	
	
	
	
	
	

}
