import java.util.LinkedList;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String contrasena;
	private String direccion;
	private static LinkedList<Cliente>  clientes = new LinkedList<Cliente>();
	private Boolean tipo;
		
	public Cliente(String nombre, String apellido, String contrasena,String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.contrasena = contrasena;
		
		}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public void Registro_Cliente(Cliente cliente) {
		   
	

	
	}
	
	
	
	

}
