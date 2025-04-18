import java.util.LinkedList;

public class Cliente {
	
	private String nombre;
	private String apellido;
	private String direccion;
	private LinkedList<Cliente> clientes;
	private Boolean tipo;
		
	public Cliente(String nombre, String apellido, String direccion,  Boolean tipo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.tipo = tipo;
		}
	

}
