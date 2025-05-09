package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BLL.Cliente;
import BLL.Empresa;
import BLL.Personal;
import repositorio.AdministradorRepository;
import repositorio.ClienteRepository;
import repositorio.Validador;

public class ControllerAdmin <T extends Cliente> implements AdministradorRepository, Validador {
	private static Connection con = Conexion.getInstance().getConnection();// Poner esto en todos los controladores

	@Override
    public T login() {
        T administrador = null;
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM administrador WHERE  apellido = ? AND 	nro_empleado = ?"
            );
            String apellido=validarCaracteres("Ingrese su Apellido");
       	 	String numeroEmpleado=validarPassword("Ingrese su Numero de Empleado");
            stmt.setString(1, apellido);
            stmt.setString(2, numeroEmpleado);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               int id = rs.getInt("id_administrador");
                String nombre = rs.getString("nombre");
//                String dirreccion = rs.getString("tipo");
                int tipo=rs.getInt("id_categoria_administrasdor");

                switch (tipo) {
                    case 1:
                    	administrador = (T) new AdminEnvios (nombre,apellido,numeroEmpleado);
                        break;
                    case 2:
                    	administrador = (T) new AdminVentas(nombre,apellido,numeroEmpleado);
                        break;
                    default:
                        System.out.println("Tipo de cliente desconocido: " + tipo);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return administrador;
    }

	 
	 
	
	
	
	
}
