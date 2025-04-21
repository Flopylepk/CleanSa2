import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Cliente implements Validador {
	
	private String nombre;
	
	private String contrasena;
	private String direccion;
	private String dni;
	private static LinkedList<Cliente>  clientes = new LinkedList<Cliente>();
	private Boolean tipo;
		
	public Cliente(String nombre, String contrasena,String direccion,String dni) {
		this.nombre = nombre;
	
		this.direccion = direccion;
		this.contrasena = contrasena;
		this.dni= dni;
		
		}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static LinkedList<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(LinkedList<Cliente> clientes) {
		Cliente.clientes = clientes;
	}

	public Boolean getTipo() {
		return tipo;
	}

	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	public void Registro_Cliente(Cliente cliente) {
		   
	
	}
	
	public boolean LogIn (Cliente cliente) {
	 String DNI="";
	 String pass= "";
	 DNI =cliente.validarCaracteres("Ingrese su DNI");
	 pass = cliente.validarCaracteres("Ingrese contraseña");
	 if (Cliente.getClientes().isEmpty()) {
		JOptionPane.showMessageDialog(null, "NO hay clientes registrados");
			return false;
		}else {
			for (Cliente item  : Cliente.getClientes()) {
				if (item.getDni().equalsIgnoreCase(dni) && item.getContrasena().equals(pass) ) {
					JOptionPane.showMessageDialog(null, "Bienvenido al menu");
					return true;
					
				}
				
			}
			
			return false;
		}
	 
	 
		
		
	}

	
	
	
	
	
	

}
