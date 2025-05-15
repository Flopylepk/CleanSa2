package DLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import BLL.*;
import repositorio.ClienteRepository;
import repositorio.Validador;

public class ControllerCliente <T extends Cliente> implements ClienteRepository, Validador{
	 private static Connection con = Conexion.getInstance().getConnection();// Poner esto en todos los controladores
	 
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
	            stmt.setString(2, contrasena);
	            
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                int id = rs.getInt("id");
	                String nombre = rs.getString("email");
	                String dirreccion = rs.getString("tipo");
	                int tipo=rs.getInt("fk_categoria_usuarios");

	                switch (tipo) {
	                    case 1:
	                        cliente = (T) new Personal(nombre,contrasena, dirreccion, DNI,tipo);
	                        break;
	                    case 2:
	                        cliente = (T) new Empresa(nombre,contrasena, dirreccion, DNI,tipo);
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
	                "INSERT INTO cliente (nombre, apellido, direccion, dni, contrasena, fk_categoria_usuarios) VALUES (?, ?, ?, ?, ?, ?)"
	            );
	            String nombre = validarCaracteres("Ingrese su nombre");	 	
	    	 	String contrasena = validarPassword("Ingrese contraseña");
	    		String direccion = validarCaracteres("Ingrese su dirección");
	    		String dni = validarCaracteres("Ingrese DNI");
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
	            statement.setString(2, null);
	            statement.setString(3, direccion);
	            statement.setString(4, dni);
	            statement.setInt(4, tipo);

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
	                int tipo = rs.getInt("tipo");
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
}
