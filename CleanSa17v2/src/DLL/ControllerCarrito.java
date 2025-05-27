package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

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
}
