package BLL;
import javax.swing.JOptionPane;

import repositorio.Validador;

public class Empresa extends Cliente implements Validador {

	public Empresa(String nombre,String contrasena ,String direccion ,String dni, int tipo) {
		super(nombre, contrasena, direccion, dni, tipo);
	}

	


	@Override
	public void Registro_Cliente(Cliente cliente) {
		String nombre =validarCaracteres("Ingrese nombre");	 	
	 	String contrasena = validarPassword("Ingrese contraseña");
		String direccion = validarCaracteres("Ingrese su dirección");
		int tipo = 0;
		String dni = validarCaracteres("Ingrese DNI");
		Empresa nuevoClienteE = new Empresa(nombre,contrasena,direccion,dni,tipo);
		
		
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
