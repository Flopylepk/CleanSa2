package DLL;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import BLL.*;
import repositorio.*;

public class ControllerCliente <T extends Cliente> implements ClienteRepository, Validador, Encriptador{
	
	private static Connection con = Conexion.getInstance().getConnection();
	 
	
	 public ControllerCliente() {
		super();
	}

	@Override
	    public T login(String DNI, String contrasena) {
	        T cliente = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM cliente WHERE dni = ? AND contrasena = ?"
	            );//copiar consulta de insert para producto
	            stmt.setString(1, DNI);
	            stmt.setString(2, encriptar(contrasena));
	            
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                int id = rs.getInt("id_cliente");
	                String nombre = rs.getString("nombre");
	                String dirreccion = rs.getString("direccion");
	                int tipo=rs.getInt("fk_categoria_usuarios");

	                switch (tipo) {
	                    case 1:
	                        cliente = (T) new Personal(nombre,desencriptar(contrasena), dirreccion, DNI,id,tipo);
	                        break;
	                    case 2:
	                        cliente = (T) new Empresa(nombre,desencriptar(contrasena), dirreccion, DNI,id,tipo);
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
	                "INSERT INTO cliente (nombre , direccion, dni, contrasena, fk_categoria_usuarios) VALUES (?, ?, ?, ?, ?)"
	            );
	            Cliente prueba=null;
	            String nombre ="";
	            String contrasena ="";
	            String direccion ="";
	            String dni ="";
	            do {
					
	            nombre = validarCaracteres("Ingrese su nombre");
	    	 	contrasena = validarPassword("Ingrese contraseña");
	    	 	direccion = validarCaracteres("Ingrese su dirección");
	    		dni = validarCaracteres("Ingrese DNI");
	    		prueba=validar(dni);
	            } while (prueba!=null);
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
	            statement.setString(2, direccion);
	            statement.setString(3, dni);
	            statement.setString(4, encriptar(contrasena) );
	            statement.setInt(5, tipo);

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
	                int tipo = rs.getInt("fk_categoria_usuarios");
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


	@Override
	public <T> T validar(String dni) {
		 T cliente = null;
		try {
            PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM cliente WHERE dni = ?"
            );//copiar consulta de insert para producto
            
            stmt.setString(1, dni);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	JOptionPane.showMessageDialog(null, "ese cliente ya existe, ingreselo nuevamente");
                int id = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String contrasena = rs.getString("contrasena");
                String dirreccion = rs.getString("direccion");
                int tipo=rs.getInt("fk_categoria_usuarios");

                switch (tipo) {
                    case 1:
                        cliente = (T) new Personal(nombre,contrasena, dirreccion, dni,tipo);
                        break;
                    case 2:
                        cliente = (T) new Empresa(nombre,contrasena, dirreccion, dni,tipo);
                        break;
                    default:
                        System.out.println("Tipo de cliente desconocido: " + tipo);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            cliente=null;
        }
        return cliente;
	}
}
