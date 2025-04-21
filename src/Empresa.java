import javax.swing.JOptionPane;

public class Empresa extends Cliente implements Validador {
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
		String nombre = cliente.validarCaracteres("Ingrese nombre");
	 	String apellido = cliente.validarCaracteres("Ingrese apellido");
	 	String contrasena = cliente.validarCaracteres("Ingrese contraseña");
		String direccion = cliente.validarCaracteres("Ingrese su dirección");
		String gerente = cliente.validarCaracteres("Ingrese nombre de su gerente");
		Boolean tipo = true;
		String dni = cliente.validarCaracteres("Ingrese DNI");
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
