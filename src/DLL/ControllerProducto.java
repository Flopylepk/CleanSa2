package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import BLL.Producto;


public class ControllerProducto {
	 private static Connection con = Conexion.getInstance().getConnection();// Poner esto en todos los controladores

	 public LinkedList<Producto> mostrarUsuarios() {
		 
	        LinkedList<Producto> productos = new LinkedList<>();
	        try {
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM producto");//traer consulta de imsert
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	            	/*
	            	 * id_producto	nombre	precio	stock	fk_peligoso	fk_categoria	
tiene que coincidir dentro de " " */
	            	
	                int id = rs.getInt("id_producto");
	                String nombre = rs.getString("nombre");
	                int stock = rs.getInt("precio");
	                int precio = rs.getInt("stock");
	                int peligoso = rs.getInt("stock");
	                int categoria = rs.getInt("stock");
	               
	                
	                
	                /*	this.nombre = nombre;
		this.stcok = stcok;
		this.precio = precio;
		this.categoria = categoria;
		this.peligroso = peligroso;*/
	                productos.add(new Producto(nombre, stock, precio, peligoso, categoria));
	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return productos;
	    }
}
