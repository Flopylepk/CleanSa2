import javax.swing.JOptionPane;

public class Empresa extends Cliente {
	private String gerente;

	public Empresa(String nombre, String apellido,String contrasena ,String direccion,String gerente ,Boolean tipo, String dni) {
		super(nombre,  contrasena ,direccion, dni);
		this.gerente = gerente;
	}

 

	public String getGerente() {
		return gerente;
	}



	public void setGerente(String gerente) {
		this.gerente = gerente;
	}



	@Override
	public void Registro_Cliente(Cliente cliente) {
		String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
	 	String apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido:");
	 	String contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
		String direccion = JOptionPane.showInputDialog(null, "Ingrese su dirección:");
		String gerente = JOptionPane.showInputDialog(null, "Ingrese su GERENTE:");
		Boolean tipo = true;
		String dni = JOptionPane.showInputDialog("Ingrese su DNI");
		Empresa nuevoClienteE = new Empresa(nombre, apellido,contrasena,direccion,gerente,tipo,dni);
		
		
		if (Cliente.getClientes().isEmpty()) {
			Cliente.getClientes().add(nuevoClienteE);
			return;
		}else {
			for (Cliente item  : Cliente.getClientes()) {
				if (item.getDni().equalsIgnoreCase(dni) ) {
					JOptionPane.showMessageDialog(null, "Ya estas registrado");
					return;
					
				}
				
			}
			Cliente.getClientes().add(nuevoClienteE);
		}
	}
	
	

}
