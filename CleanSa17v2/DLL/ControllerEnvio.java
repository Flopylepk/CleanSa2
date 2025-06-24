package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.sql.Date;

import BLL.Carrito;

public class ControllerEnvio {
	private static Connection con = Conexion.getInstance().getConnection();// Poner esto en todos los controladores

	public void asignarEnvio (Carrito carrito, String direccion) {
		
		try {
			LocalDate fechaEntrega = LocalDate.now().plusDays(3);
			Date fechaEntregaBD = Date.valueOf(fechaEntrega);
			PreparedStatement stm = con.prepareStatement("INSERT INTO envio (fk_carrito, fecha_entrega, direccion) VALUES (?, ?, ?)");
			
			stm.setInt(1, carrito.getId_carrito());
			stm.setDate(2, fechaEntregaBD);
			stm.setString(3, direccion);
			
			PreparedStatement stm2 = con.prepareStatement("UPDATE carrito SET estado=? WHERE id_carrito=?");
			stm2.setString(1, "enviado");
			stm2.setInt(2, carrito.getId_carrito());
			
			
			stm.executeUpdate();
			stm2.executeUpdate();
			
			
		} catch (Exception e) {
			
		}
		
	}
	
}
