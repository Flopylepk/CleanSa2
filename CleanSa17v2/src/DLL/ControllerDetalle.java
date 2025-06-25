package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import BLL.Carrito;
import BLL.Pedido;
import BLL.Producto;
import repositorio.*;

public class ControllerDetalle{
	private static Connection con = Conexion.getInstance().getConnection();

	public ControllerDetalle() {
		super();
	}

	
	public static LinkedList<Producto> mostrarCarrito_detalle(int id_carrito) {
		LinkedList<Pedido> pedido = new LinkedList<>();
		LinkedList<Producto> productos = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM carrito_detalle");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	int fk_carrito=rs.getInt("fk_carrito");
            	int fk_producto=rs.getInt("fk_producto");
            	int cantidad=rs.getInt("cantidad");
            	double totalPrecio=rs.getDouble("total_producto");
            	Pedido pedidos=new Pedido(fk_carrito,fk_producto,cantidad,totalPrecio);
            	
            	pedido.add(pedidos);
            	
            	PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM producto WHERE id_producto=?");
            	stmt.setInt(1, fk_producto);
            	rs = stmt.executeQuery();
            	String nombre=rs.getString("nombre");
            	double precio=rs.getDouble("precio");
            	int stock=rs.getInt("stock");
            	int fk_categoria=rs.getInt("fk_categoria");
            	int peligroso=rs.getInt("peligroso");
            	
            	Producto productos2=new Producto(nombre,stock,precio,fk_categoria,peligroso);
            	productos.add(productos2);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productos;
	}
	

}
