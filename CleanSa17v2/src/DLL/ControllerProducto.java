package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import BLL.Producto;


public class ControllerProducto  {
	 private static Connection con = Conexion.getInstance().getConnection();// Poner esto en todos los controladores
	 

public LinkedList<Producto> mostrarProductos() {
	     LinkedList<Producto> productos = new LinkedList<>();
	     try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM producto"); //traer consulta de insert
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	            	
	            	/*
	            	 * id_producto	nombre	precio	stock	fk_peligoso	fk_categoria	
						tiene que coincidir dentro de " " */

	                int id = rs.getInt("id_producto");
	                String nombre = rs.getString("nombre");
	                int stock = rs.getInt("stock");
	                int precio = rs.getInt("precio");
	                boolean peligoso = rs.getBoolean("peligroso");
	                int categoria = rs.getInt("fk_categoria");

	                /*	this.nombre = nombre;
						this.stcok = stcok;
						this.precio = precio;
						this.categoria = categoria;
						this.peligroso = peligroso;*/
	                productos.add(new Producto(nombre, stock, precio, categoria, peligoso));
	              //crea objeto con los datos de una mima fila d la base de datos
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return productos;
	    }
	public void agregarProducto (Producto producto) {
		try {
			PreparedStatement stmt = con.prepareStatement("INSERT INTO producto(nombre,"
					+ "precio, stock, fk_categoria, peligroso) "
					+ "VALUES (?,?,?,?,?)");
			
			stmt.setString(1,producto.getNombre());
			stmt.setDouble(2, producto.getPrecio());
			stmt.setInt(3, producto.getStcok());
			stmt.setInt(4, producto.getCategoria());
			stmt.setBoolean(5, producto.getPeligroso());
			stmt.executeUpdate();
			System.out.println("Producto agregado correctamente.");
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se agrego.");
		}

		}
}
	 
