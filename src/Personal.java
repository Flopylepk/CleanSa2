import javax.swing.JOptionPane;

public class Personal extends Cliente {
	private String apellido;

	public Personal(String nombre, String apellido, String contrasena ,String direccion,String dni ,Boolean tipo) {
		super(nombre, dni,contrasena,direccion);
		this.apellido = apellido;
	}
			
 


	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		if (Cliente.getClientes().isEmpty()) {
			Cliente.getClientes().add(nuevoClienteP);
			return;
		}else {
			for (Cliente item  : Cliente.getClientes()) {
				if (item.getDni().equalsIgnoreCase(dni) ) {
					JOptionPane.showMessageDialog(null, "Ya estas registrado");
					return;
					
				}
				
			}
			Cliente.getClientes().add(nuevoClienteP);
		}
	
		
		
	}
	

}

