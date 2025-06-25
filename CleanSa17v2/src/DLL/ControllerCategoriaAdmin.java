package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BLL.Administrador;
import repositorio.AdministradorRepository;
import repositorio.Encriptador;
import repositorio.Validador;

public class ControllerCategoriaAdmin implements AdministradorRepository, Validador, Encriptador {

    private static Connection con = Conexion.getInstance().getConnection(); // Poner esto en todos los controladores

    
    public int obtenerCategorias() {
    	
    	int idCategoria = 0; // Inicializar la variable antes de usarla
    	
        try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT `id_categoria_administrasdor` FROM `categoria_administrasdor`"
            );

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                 idCategoria = rs.getInt("id_categoria_administrasdor");
                System.out.println("ID Categoría: " + idCategoria);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return idCategoria;
    }

    @Override
    public <T> T logIn() {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	public <T> T logIn(String nombre, String contrasena) {
		// TODO Auto-generated method stub
		return null;
	}
}
