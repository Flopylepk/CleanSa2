package BLL;
import javax.swing.JOptionPane;

import repositorio.Validador;

public class Personal extends Cliente implements Validador{

	public Personal(String nombre, String contrasena ,String direccion,String dni ,int tipo) {
		super(nombre, contrasena, direccion, dni, tipo);
	}
	@Override
	public void Registro_Cliente(Cliente cliente) {
		
		String nombre =cliente.validarCaracteres("Ingrese su nombre:");
	 	String contrasena = cliente.validarPassword("Ingrese contraseña");
	 	String direccion = cliente.validarCaracteres("Ingrese su dirección");
		String dni = cliente.validarCaracteres("Ingrese su dni");
		int tipo = 0;
		Personal nuevoClienteP = new Personal(nombre,contrasena,direccion,dni,tipo);
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

