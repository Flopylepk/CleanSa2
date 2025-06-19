package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Producto;


public class ControllerProducto  {
	private static Connection con = Conexion.getInstance().getConnection();// Poner esto en todos los controladores

	 
	public static LinkedList<Producto> mostrarProductos() {

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
	                double precio = rs.getDouble("precio");
	                int peligoso = rs.getInt("peligroso");
	                int categoria = rs.getInt("fk_categoria");
	                /*	this.nombre = nombre;
						this.stcok = stcok;
						this.precio = precio;
						this.categoria = categoria;
						this.peligroso = peligroso;*/
	                productos.add(new Producto(nombre, precio, stock,categoria, peligoso,id));
	              //crea objeto con los datos de una mima fila d la base de datos
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return productos;
	    }	 
	 ////MOSTRAR PRODUCTOS PELIGROSOS	 
	 public static LinkedList<Producto> mostrarProductosNoPeligrosos() {		 
	        LinkedList<Producto> productos = new LinkedList<>();
	        try {
	        						////SOLO TRAE PRODUCTOS CON PELIGROSO = 0 
	            PreparedStatement stmt = con.prepareStatement("SELECT * FROM producto WHERE peligroso = ? and stock>?"); //traer consulta de insert
	            stmt.setInt(1, 1);
	            stmt.setInt(2, 0);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {	            	
	            	/*
	            	 * id_producto	nombre	precio	stock	fk_peligoso	fk_categoria	
						tiene que coincidir dentro de " " */

	                int id = rs.getInt("id_producto");
	                String nombre = rs.getString("nombre");
	                int stock = rs.getInt("stock");
	                double precio = rs.getDouble("precio");
	                int peligoso = rs.getInt("peligroso");
	                int categoria = rs.getInt("fk_categoria");                
	                /*	this.nombre = nombre;
						this.stcok = stcok;
						this.precio = precio;
						this.categoria = categoria;
						this.peligroso = peligroso;*/

	                productos.add(new Producto(nombre, precio, stock,categoria, peligoso,id));
	               


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
			stmt.setInt(5, producto.getPeligroso());
			stmt.executeUpdate();
			System.out.println("Producto agregado correctamente.");
	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se agrego.");
		}
		}
	
	////FUNCION DE ELEGIR PARA USUARIOS TIPO PERSONAL 
	public int elegirNoPeligroso() {
		LinkedList<Producto> productos = mostrarProductosNoPeligrosos();
        String []lista = new String[productos.size()];
        for (int i = 0; i < productos.size(); i++) {
        	lista[i] = productos.get(i).getNombre() +"/" + productos.get(i).getId();
		}
        String opcion = (String)JOptionPane.showInputDialog(null, "", "", 0,  null, lista, lista[0]);       
        int idElegido = Integer.parseInt( opcion.split("/")[1]);
        return idElegido;
	}	
////FUNCION DE ELEGIR PARA USUARIOS TIPO EMPRESA
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
	
	public void cargarStock (int cantidad) {
			
	}
	
	//Validacion para la base de datoos para saber si el productor que el Administrador quiere añadir ya esta en el sistema o no.
	public boolean encontrarProductos (String nombre) {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT COUNT(*) FROM producto WHERE LOWER(nombre) = LOWER(?)");
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

 
