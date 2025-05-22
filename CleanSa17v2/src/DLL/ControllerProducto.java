package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Producto;


public class ControllerProducto {
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
	                int stock = rs.getInt("precio");
	                int precio = rs.getInt("stock");
	                int peligoso = rs.getInt("peligroso");
	                int categoria = rs.getInt("fk_categoria");
	                
	                /*	this.nombre = nombre;
						this.stcok = stcok;
						this.precio = precio;
						this.categoria = categoria;
						this.peligroso = peligroso;*/
	                productos.add(new Producto(nombre, stock, precio, peligoso, categoria,id));
	               
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return productos;
	    }

	public void agregarProducto (Producto producto) {
	
	
		}
	
	public int elegir() {
		LinkedList<Producto> productos = mostrarProductos();
        String []lista = new String[productos.size()];
        for (int i = 0; i < productos.size(); i++) {
        	lista[i] = productos.get(i).getNombre() +"/" + productos.get(i).getId();
		}
        String opcion = (String)JOptionPane.showInputDialog(null, "", "", 0,  null, lista, lista[0]);
        
        int idElegido = Integer.parseInt( opcion.split("/")[1]);
        return idElegido;
	}
	


}
	 
