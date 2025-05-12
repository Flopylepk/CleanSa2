package DLL;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DLL.Conexion;

public class ControllerCategoria {
	private static Connection con = Conexion.getInstance().getConnection();
	

    // Método para obtener el id_categoria a partir del nombre
    public int fk_categoria(String nombreCategoria) {
        int idCategoria = -1;  // Si no se encuentra la categoría, se devuelve -1.
        
        try {
            String sql = "SELECT id_categoria FROM categoria WHERE nombre = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nombreCategoria);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                idCategoria = rs.getInt("id_categoria");  // Obtenemos el ID de la categoría
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return idCategoria;
    }
}

