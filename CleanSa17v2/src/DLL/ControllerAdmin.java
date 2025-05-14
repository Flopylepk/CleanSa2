package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import BLL.*;
import repositorio.*;

public class ControllerAdmin <T extends Administrador> implements AdministradorRepository, Validador, Encriptador{

	public ControllerAdmin() {
		super();
	}

	private static Connection con = Conexion.getInstance().getConnection();// Poner esto en todos los controladores

	@Override
    public T login() {
        T administrador = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM administrador WHERE  nombre = ? AND contrasena=?"
            );
            String nombre=validarCaracteres("Ingrese su nombre");
            String contrasena=validarPassword("ingrese su contraseña");
            
            
            stmt.setString(1, nombre);
            stmt.setString(2, encriptar(contrasena));
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               int id = rs.getInt("id_administrador");
                String apellido = rs.getString("apellido");
                int tipo=rs.getInt("fk_categoria_administrasdor");

                switch (tipo) {
                    case 1:
                    	administrador = (T) new AdminEnvios (nombre,apellido, id, tipo, desencriptar(contrasena) );
                        break;
                    case 2:
                    	administrador = (T) new AdminVentas(nombre,apellido, id, tipo, desencriptar(contrasena));
                        break;
                    default:
                        System.out.println("Tipo de administrador desconocido: " + tipo);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrador;
    }

	 
	 
	
	
	
	
}
