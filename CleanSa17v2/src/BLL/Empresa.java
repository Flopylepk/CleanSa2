package BLL;
import javax.swing.JOptionPane;

import repositorio.Validador;

public class Empresa extends Cliente implements Validador {

	public Empresa(String nombre,String contrasena ,String direccion ,String dni, int tipo) {
		super(nombre, contrasena, direccion, dni, tipo);
	}

	public Empresa(String nombre, String contrasena, String direccion, String DNI, int id, int tipo) {
		super(nombre, contrasena, direccion, DNI, id, tipo);
	}
	

	


	
	
	
	

}
