package DLL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import BLL.*;
import repositorio.*;
import DLL.*;

public class ControllerCliente <T extends Cliente> implements ClienteRepository, Validador, Encriptador{
	
	private static Connection con = Conexion.getInstance().getConnection();
	 
	
	 public ControllerCliente() {
		super();
	}

	@Override
	    public T login() {
	        T cliente = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM cliente WHERE dni = ? AND contrasena = ?"
	            );//copiar consulta de insert para producto
	            String DNI=validarCaracteres("Ingrese su DNI");
	       	 	String contrasena=validarPassword("Ingrese contraseña");
	            stmt.setString(1, DNI);
	            stmt.setString(2, encriptar(contrasena));
	            
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                int id = rs.getInt("id_cliente");
	                String nombre = rs.getString("nombre");
	                String dirreccion = rs.getString("direccion");
	                int tipo=rs.getInt("fk_categoria_usuarios");

	                switch (tipo) {
	                    case 1:
	                        cliente = (T) new Personal(nombre,desencriptar(contrasena), dirreccion, DNI,id,tipo);
	                        break;
	                    case 2:
	                        cliente = (T) new Empresa(nombre,desencriptar(contrasena), dirreccion, DNI,id,tipo);
	                        break;
	                    default:
	                        System.out.println("Tipo de cliente desconocido: " + tipo);
	                        break;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return cliente;
	    }
	 
	 @Override
	    public void agregarCliente() {
	        try {
	            PreparedStatement statement = con.prepareStatement(
	                "INSERT INTO cliente (nombre , direccion, dni, contrasena, fk_categoria_usuarios) VALUES (?, ?, ?, ?, ?)"
	            );
	            Cliente prueba=null;
	            String nombre ="";
	            String contrasena ="";
	            String direccion ="";
	            String dni ="";
	            do {
					
	            nombre = validarCaracteres("Ingrese su nombre");
	    	 	contrasena = validarPassword("Ingrese contraseña");
	    	 	direccion = validarCaracteres("Ingrese su dirección");
	    		dni = validarCaracteres("Ingrese DNI");
	    		prueba=validar(dni);
	            } while (prueba!=null);
	    		int tipo=0;
	    		do {
	    			String tipo1=validarCaracteres("Ingrese su tipo de ususario (Personal o empresa)");
		    		if (tipo1.equalsIgnoreCase("personal")) {
						tipo=1;
					} else if(tipo1.equalsIgnoreCase("empresa")){
						tipo=2;
					}
		    		if (tipo==0) {
						JOptionPane.showMessageDialog(null, "el tipo de usuario es incorrecto, ingreselo nuevamente");
					}
				} while (tipo==0);
	    		
	            statement.setString(1, nombre );
	            statement.setString(2, direccion);
	            statement.setString(3, dni);
	            statement.setString(4, encriptar(contrasena) );
	            statement.setInt(5, tipo);

	            int filas = statement.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Cliente agregado correctamente.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public LinkedList<Cliente> mostrarClientes() {
        LinkedList<Cliente> Clientes = new LinkedList<>();
        try {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	  int id_cliente = rs.getInt("id_cliente");
	                String nombre = rs.getString("nombre");
	                String direccion = rs.getString("direccion");
	                int tipo = rs.getInt("fk_categoria_usuarios");
	                String contrasena = rs.getString("contrasena");
	                String dni = rs.getString("dni");
	                Cliente cliente= new Cliente(nombre, contrasena, direccion, dni,id_cliente ,tipo);
	                
	                Clientes.add(cliente);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Clientes;
    }
	
	public static Cliente obtenerClientesPorID(int id) {
		Cliente cliente =new Cliente(null, null, null, null, 0);
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM cliente WHERE id = ?"
	            );
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();

	            if(rs.next()) {
	                int id_cliente = rs.getInt("id_cliente");
	                String nombre = rs.getString("nombre");
	                String direccion = rs.getString("direccion");
	                int tipo = rs.getInt("tipo");
	                String contrasena = rs.getString("contrasena");
	                String dni = rs.getString("dni");
	                cliente= new Cliente(nombre, contrasena, direccion, dni,id_cliente ,tipo);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return cliente;
	    }


	@Override
	public <T> T validar(String dni) {
		 T cliente = null;
		try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM cliente WHERE dni = ?"
            );//copiar consulta de insert para producto
            
            stmt.setString(1, dni);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	JOptionPane.showMessageDialog(null, "ese cliente ya existe, ingreselo nuevamente");
                int id = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String contrasena = rs.getString("contrasena");
                String dirreccion = rs.getString("direccion");
                int tipo=rs.getInt("fk_categoria_usuarios");

                switch (tipo) {
                    case 1:
                        cliente = (T) new Personal(nombre,contrasena, dirreccion, dni,tipo);
                        break;
                    case 2:
                        cliente = (T) new Empresa(nombre,contrasena, dirreccion, dni,tipo);
                        break;
                    default:
                        System.out.println("Tipo de cliente desconocido: " + tipo);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            cliente=null;
        }
        return cliente;
	}

	@Override
	public void comprar(int id) {
		try {
			 PreparedStatement statement = con.prepareStatement(
		                "INSERT INTO carrito (fecha , estado, total, codigoenvio, fk_cliente) VALUES (?,?, ?, ?, ?, ?)"
					 );
			 Carrito carrito = null;
			 Date fecha= Date.valueOf(LocalDate.now());
			 String estado="en proceso";
			 double total = 0;
			// boolean estadoenvio= false;
			 int codigoenvio= (int)Math.random()*1001+100;
			 int fk_cliente= id;
			 
			 	statement.setDate(1, fecha );
	            statement.setString(2, estado);
	            statement.setDouble(3, total);
	            //ya no hay estado envio
	         //   statement.setBoolean(4, estadoenvio );
	            statement.setInt(4, codigoenvio);
	            statement.setInt(5, fk_cliente);
	            
	         
	            PreparedStatement statement2 = con.prepareStatement(
		                "SELECT id_carrito FROM carrito WHEN estado='en proceso' and id_cliente = ?"
					 );
	            
	            statement2.setInt(1, id);
	            ResultSet rs = statement2.executeQuery(); 
	            
	            int id_carrito=rs.getInt("id_carrito");
	            
	            ControllerProducto controller=new ControllerProducto();
	            String opciones[]={"si", "no"};
	            int opcion=0;
	            int id_producto=0;
	            
	            PreparedStatement carritopendiente = con.prepareStatement(
		                "SELECT * FROM carrito WHEN fk_cliente=? and estado=?"
					 );
	            carritopendiente.setInt(1, id);
	            carritopendiente.setString(2, "en proseso");
	            
           	 ResultSet cp2 = statement2.executeQuery();
           	 if (cp2==null) {
           		 do {
 	            	JOptionPane.showMessageDialog(null, "agreguemos productos a nuestro acarrito");
 	            	id_producto=controller.elegir();
 	            	////VAlidar si ya lo tiene en el carrito
 	            	PreparedStatement carritoproducto = con.prepareStatement(
 			                "SELECT * FROM carrito WHEN fk_cliente=? and estado=? "
 						 );
 		            carritopendiente.setInt(1, id);
 		            carritopendiente.setString(2, "en proseso");
 		            
 	           	 ResultSet cp3 = statement2.executeQuery();
 	           	 
 	           	 
 	            	PreparedStatement statement3 = con.prepareStatement(
 			                "SELECT * FROM producto WHEN id_producto=?"
 						 );
 	            	 statement3.setInt(1, id_producto);
 	            	 ResultSet rs2 = statement2.executeQuery();
 	            	 
 	                 /////Validamos el perfil de cliente con el tipo de producto (PELIGROSO)
 	               	 PreparedStatement cateCliente = con.prepareStatement(
 	    		                "SELECT fk_categoria_usuarios FROM cliente WHERE id_cliente=?"
 	    					 );
 	               	 
 	               	 cateCliente.setInt(1, id);
 	               	 ResultSet rs4 = cateCliente.executeQuery();
 	               	 
 	               	 // guardamos la categoria de usuario en un int
 	               	 int cliente = rs4.getInt("fk_categoria_usuario") ;
 	            	
 	            	 ////query para buscar categoria del producto
 	            	 PreparedStatement catProducto = con.prepareStatement(
 	            			 "SELECT  peligroso FROM producto WHERE id_producto=? "	            			 
 	            			 );
 	            	 
 	            	 catProducto.setInt(1, id_producto);
 	            	 ResultSet rs5 = catProducto.executeQuery();
 	            	 
 	            	 //guardamos el resultado de peligroso en un int
 	            	 int produc = rs5.getInt("peligroso");

 	            	 
 	            	 //Validar si hay stock
 	            	int cantidadstock=rs2.getInt("stock");
 	            	while (cantidadstock==0) {
 	            		JOptionPane.showMessageDialog(null, "este producto no tiene stock");
 	            		id_producto=controller.elegir();
 		            	 statement3.setInt(1, id_producto);
 		            	  rs2 = statement2.executeQuery();
 		            	 cantidadstock=rs2.getInt("stock");
 					}
 	            	
 	            	//Validar si la cantidad es 0 o si es mayor al stock
 	            	int cantidadcompra=validarNumeros("ponga la cantidad de stock que quiere ingresar");
 	            	while (cantidadcompra>0 || cantidadcompra>cantidadstock) {
 	            		if (cantidadcompra>0) {
 							JOptionPane.showMessageDialog(null, "La cantidad de producto que elija no puede ser 0");
 						}
 	            		if (cantidadcompra>cantidadstock) {
 							JOptionPane.showMessageDialog(null, "La cantidad que eligio es mayor a la cantidad del stock");
 						}
 	            		cantidadcompra=validarNumeros("ponga la cantidad de stock que quiere ingresar");
 					}
 	            	
 	            	//agregamos el producto y el carrito al pedido
 	            	PreparedStatement carrito_detalle = con.prepareStatement(
 			                "INSERT INTO carrito_detalle(fk_carrito, fk_producto, total_producto) VALUES (?,?)"
 						 );
 	            	carrito_detalle.setInt(1, id_carrito);
 	            	carrito_detalle.setInt(2, id_producto);
 	            	carrito_detalle.setInt(3, cantidadcompra*rs2.getInt("precio"));
 	            	
 	            	
 	           
 	            	//Modificar la cantidad del producto
 	            	PreparedStatement update = con.prepareStatement(
 			                "UPDATE producto SET stock=? WHEN id_producto=?"
 						 );
 	            	
 	            	update.setInt(1, cantidadstock-cantidadcompra);
 	            	update.setInt(2, id_producto);
 	            	 
 					opcion=JOptionPane.showOptionDialog(null, "quiere agregar más productos", null, 0, 0, null, opciones, opciones[0]);
 				} while (opcion!=1);
			} else {
				JOptionPane.showMessageDialog(null,"Ya tiene un carrito pendiente, no puede comprar otro" );
			}
	            
	            
            
	           
	            
	          
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		
	}

	@Override
	public static void carrito(int id) {
		try {
			PreparedStatement validar = con.prepareStatement(
	                "Select * FROM carrito WHERE fk_cliente=? AND estado=?"
					);
			validar.setInt(1, id );
			validar.setString(2, "en proseso");
			ResultSet rs = validar.executeQuery();
			if (rs==null) {
				PreparedStatement statement = con.prepareStatement(
		                "INSERT INTO carrito (fecha , estado, total, codigoenvio, fk_cliente) VALUES (?,?, ?, ?, ?, ?)"
					 );
			 Carrito carrito = null;
			 Date fecha= Date.valueOf(LocalDate.now());
			 String estado="en proceso";
			 double total = 0;
			// boolean estadoenvio= false;
			 int codigoenvio= (int)Math.random()*1001+100;
			 int fk_cliente= id;
			 
			 	statement.setDate(1, fecha );
	            statement.setString(2, estado);
	            statement.setDouble(3, total);
	            //ya no hay estado envio
	         //   statement.setBoolean(4, estadoenvio );
	            statement.setInt(4, codigoenvio);
	            statement.setInt(5, fk_cliente);
			} else {
				JOptionPane.showMessageDialog(null, "no se puede agregar otro carrito porque ya existe uno");
			}
			
			
			
            
		} catch (Exception e) {
			
		}
			 
		
	}
}
