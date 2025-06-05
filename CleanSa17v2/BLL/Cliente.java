package BLL;

import java.util.LinkedList;
import DLL.*;

import javax.swing.JOptionPane;

import repositorio.Validador;

public class Cliente implements Validador {

	private String nombre;
	private String contrasena;
	private String direccion;
	private String dni;
	private static LinkedList<Cliente> clientes = new LinkedList<Cliente>();
	private int tipo;
	private int id;
	
	public Cliente() {}

	public Cliente(String nombre, String contrasena, String direccion, String DNI, int tipo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.contrasena = contrasena;
		this.dni = DNI;
	}

	public Cliente(String nombre, String contrasena, String direccion, String DNI, int id, int tipo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.contrasena = contrasena;
		this.dni = DNI;
		this.id = id;
		this.tipo = tipo;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + "\n contrasena=" + contrasena + "\n direccion=" + direccion + "\n dni="
				+ dni + "\n tipo=" + tipo + "\n id=" + id + "]";
	}

	public static Cliente Login(String DNI, String contrasena) {
		if (DNI.isEmpty() || contrasena.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Error");
			return null;
		} else {
			ControllerCliente controllercliente = new ControllerCliente();
			return controllercliente.login(DNI, contrasena);
		}

	}

	public void agregarClienteProfe(String nombre, String contrasena, String direccion, String dni, String tipo) {
	
		ControllerCliente controller=new ControllerCliente();
		Cliente prueba = null;
		
		
			nombre = this.validarCaracteres(nombre);
			if (nombre.equals(null)) {
				JOptionPane.showMessageDialog(null, "el nombre esta vacio");
				return;
			}
			
			contrasena = this.validarPassword(contrasena);
			if (contrasena.equals(null)) {
				JOptionPane.showMessageDialog(null, "la contraseña esta vacia");
				return;
			}
			direccion = this.validarCaracteres(direccion);
			if (direccion.equals(null)) {
				JOptionPane.showMessageDialog(null, "la direccion esta vacia");
				return;
			}
			dni = this.validarCaracteres(dni);
			if (dni.equals(null)) {
				JOptionPane.showMessageDialog(null, "el dni esta vacio");
				return;
			}
			
			prueba = (Cliente) ControllerCliente.validar2(dni);
			if (prueba!=null) {
				JOptionPane.showMessageDialog(null, "ese cliente ya existe");
				return;
			}
			
		int tipo2 = 0;
			String tipo1 = tipo;
			if (tipo1.equalsIgnoreCase("personal")) {
				tipo2 = 1;
			} else if (tipo1.equalsIgnoreCase("empresa")) {
				tipo2 = 2;
			}

		ControllerCliente.agregarCliente2(nombre, contrasena, direccion, dni, tipo2);
	}

}
