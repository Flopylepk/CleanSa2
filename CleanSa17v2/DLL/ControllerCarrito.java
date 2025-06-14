package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import BLL.*;
import repositorio.*;


public class ControllerCarrito implements  CarritoRepository{
	
	private static Connection con = Conexion.getInstance().getConnection();

	public ControllerCarrito() {
		super();
	}

	@Override
	public List<Carrito> mostrarCarrito() {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}
	
	@Override
	public List<Carrito> mostrarCarritoEnProseso() {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where estado=?");
			stmt.setString(1, "en proseso");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}

	@Override
	public List<Carrito> mostrarCarritosPagados() {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where estado=?");
			stmt.setString(1, "pagado");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}
	
	//Metodo para usar los carritos sin envio asignado 
	public List<Carrito> mostrarCarritosPagadosSinEnvio() {
	    LinkedList<Carrito> carrito = new LinkedList<>();
	    try {
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito WHERE estado = ? AND codigo_envio = 0");
	        stmt.setString(1, "pagado");
	        ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	            int id_carrito = rs.getInt("id_carrito");
	            Date fecha = rs.getDate("fecha");
	            String estado = rs.getString("estado");
	            double total = rs.getDouble("total");
	            int codigo_envio = rs.getInt("codigo_envio");
	            int fk_cliente = rs.getInt("fk_cliente");
	            Carrito carritos = new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
	            carrito.add(carritos);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return carrito;
	}

	@Override
	public List<Carrito> mostrarCarritoCancelados() {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where estado=?");
			stmt.setString(1, "cancelado");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}

	@Override
	public List<Carrito> mostrarCarritoporCliente(int id) {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where fk_cliente=?");
			stmt.setInt(1, id);
			
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}

	

	@Override
	public List<Carrito> mostrarCarritoporClienteEnProseso(int id) {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where fk_cliente=? and estado=?");
			stmt.setInt(1, id);
			stmt.setString(2, "en proseso");
			
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}

	@Override
	public List<Carrito> mostrarCarritoporClientePagados(int id) {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where fk_cliente=? and estado=?");
			stmt.setInt(1, id);
			stmt.setString(2, "pagado");
			
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}

	@Override
	public List<Carrito> mostrarCarritoporClienteCancelados(int id) {
		LinkedList<Carrito> carrito = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where fk_cliente=? and estado=?");
			stmt.setInt(1, id);
			stmt.setString(2, "cancelado");
			
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int id_carrito=rs.getInt("id_carrito");
            	Date fecha= rs.getDate("fecha");
            	String estado=rs.getString("estado");
            	double total=rs.getDouble("total");
            	int codigo_envio=rs.getInt("codigo_envio");
            	int fk_cliente=rs.getInt("fk_cliente");
            	Carrito carritos=new Carrito(id_carrito, fecha, estado, total, codigo_envio, fk_cliente);
            	
            	carrito.add(carritos);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carrito;
	}
	
	public void pagar(int id) {
		
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where fk_cliente=? and estado=?");
			stmt.setInt(1, id);
			stmt.setString(2, "en proceso");
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				
					PreparedStatement cambio = con.prepareStatement("UPDATE carrito SET estado=? WHERE fk_cliente=? and estado=?");
					cambio.setString(1, "pagado");
					cambio.setInt(2, id);
					cambio.setString(3, "en proceso");
					int filas = cambio.executeUpdate();
					if (filas>1) {
						JOptionPane.showMessageDialog(null, "pago realizado");
						System.out.println("modifico carrito");
					}
				
            }else {
				JOptionPane.showMessageDialog(null, "no se encontro ningun carrito en proceso. Antes de pagar debe realizar una compra");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void cancelar(int id) {
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito where fk_cliente=? and estado=?");
			stmt.setInt(1, id);
			stmt.setString(2, "en proceso");
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				
					PreparedStatement detalle = con.prepareStatement("SELECT * FROM carrito_detalle where fk_cliente=? and fk_carrito=?");
					detalle.setInt(1, id);
					detalle.setInt(2, rs.getInt(id));
					ResultSet rs2 = detalle.executeQuery();
					while(rs.next()) {
		            	int id_carrito_detalle=rs2.getInt("id_carrito_detalle");
		            	int fk_carrito=rs2.getInt("fk_carrito");
		            	int fk_producto=rs2.getInt("fk_producto");
		            	double total_producto=rs2.getDouble("total_producto");
		            	int cantidad=rs2.getInt("cantidad");
		            	
		            	PreparedStatement producto = con.prepareStatement("SELECT * FROM producto where id_producto=?");
		            	producto.setInt(1, fk_producto);
		            	ResultSet rs3 = producto.executeQuery();
		            	
		            	int cantidad_producto=0;
		            	if (rs3.next()) {
		            		cantidad_producto=rs3.getInt("stock");
						}
		            
		            	int total_cambio=cantidad+cantidad_producto;
		            	
		            	PreparedStatement producto_cambio = con.prepareStatement("UPDATE producto SET stock`=? WHERE id_producto=?");
		            	producto_cambio.setInt(1, total_cambio);
		            	producto_cambio.setInt(2, fk_producto);
		            	int filas = producto_cambio.executeUpdate();
						if (filas>1) {
							System.out.println("modifico producto");  
						}
		            	
		            }
					
					PreparedStatement cambio = con.prepareStatement("UPDATE carrito SET estado=? WHERE fk_cliente=? and estado=?");
					stmt.setString(1, "cancelado");
					stmt.setInt(2, id);
					cambio.setString(3, "en proceso");
					int filas2 = cambio.executeUpdate();
					if (filas2>1) {
						System.out.println("modifico carrito");
						JOptionPane.showMessageDialog(null, "cancelacion realizada correctamente");
					}
				}else {
					JOptionPane.showMessageDialog(null, "no se encontro ningun carrito en proceso. Antes de cancelar debe realizar una compra");
				}
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
