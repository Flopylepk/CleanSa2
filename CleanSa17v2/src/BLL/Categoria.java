package BLL;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;

import DLL.Conexion;

public class Categoria {
	
	private int id_categoria;
	private String nombre;
	public Categoria(int id_categoria, String nombre) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return  nombre;
	}
	
	
	
}
