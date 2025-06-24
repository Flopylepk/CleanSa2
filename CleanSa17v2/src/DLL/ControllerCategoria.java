package DLL;
import com.mysql.jdbc.Connection;
import BLL.Categoria;
import BLL.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import DLL.Conexion;

public class ControllerCategoria {
	private static Connection con = Conexion.getInstance().getConnection();
	
	public  LinkedList<Categoria> mostrarCategorias(){
		LinkedList<Categoria> categoria = new LinkedList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM categoria");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id_categoria");
				String nombre = rs.getString("nombre");
				
				categoria.add(new Categoria(id, nombre)); 
				//crea objeto con los datos de una mima fila d la base de datos
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoria;
		
	}
	
	
	public void crearCategoria(Categoria categoria) { //Consulta para agregar categoria
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO categoria(nombre) VALUES (?)");
			
			stmt.setString(1, categoria.getNombre()); 
			stmt.executeUpdate(); 
			
			System.out.println("Categoria agregada correctamente.");
			
			
		} catch (Exception e) {
			System.out.println("Error, no se agrego.");
		}
		
		
		
		
	}
	
	public boolean encontrarCategorias(String nombre) {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) from categoria where LOWER(nombre) = LOWER(?)");
			stmt.setString(1, nombre);
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}
}

