package DLL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import BLL.Carrito;
import BLL.Pedido;
import repositorio.*;

public class ControllerDetalle implements  DetalleRepository{
	private static Connection con = Conexion.getInstance().getConnection();

	public ControllerDetalle() {
		super();
	}

	@Override
	public List<Pedido> mostrarCarrito_detalle(int id_carrito) {
		LinkedList<Pedido> pedido = new LinkedList<>();
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
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedido;
	}
	

}
