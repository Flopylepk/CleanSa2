import javax.swing.JOptionPane;

public class Personal extends Cliente{
	private String dni;

	public Personal(String nombre, String apellido, String contrasena ,String direccion,String dni ,Boolean tipo) {
		super(nombre, apellido,contrasena,direccion);
		this.dni = dni;
	}
			

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	@Override
	public void Registro_Cliente(Cliente cliente) {
		
		String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
	 	String apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido:");
	 	String contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
		String direccion = JOptionPane.showInputDialog(null, "Ingrese su dirección:");
		String dni = JOptionPane.showInputDialog(null, "Ingrese su DNI:");
		Boolean tipo = false;
		Personal nuevoClienteP = new Personal(nombre, apellido,contrasena,direccion,dni,tipo);
		for (Cliente item  : Cliente.getClientes()) {
			if (item.getNombre().equals(nuevoClienteP.getNombre()) && item.getApellido().equals(nuevoClienteP.getApellido())
					&& item.getDireccion().equals(nuevoClienteP.getDireccion())) {
				JOptionPane.showMessageDialog(null, "Ya estas registrado");
				
			}
			
		}
		Cliente.getClientes().add(nuevoClienteP);
		
	}
	

}

