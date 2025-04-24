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
		String nombre =validarCaracteres("Ingrese nombre");
	 	String apellido = validarCaracteres("Ingrese apellido");
	 	/////CAMBIAR POR VALIDADOR ESPECIFICO DE LA PASSWORD
	 	String contrasena = validarPassword("Ingrese contraseña");
		String direccion = validarCaracteres("Ingrese su dirección");
		String gerente = validarCaracteres("Ingrese nombre de su gerente");
		Boolean tipo = true;
		String dni = validarCaracteres("Ingrese DNI");
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
