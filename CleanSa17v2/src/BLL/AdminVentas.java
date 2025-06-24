package BLL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import DLL.ControllerProducto;


import repositorio.Validador;

public class AdminVentas extends Administrador implements Validador {	
	public AdminVentas(String nombre, String apellido, int id, int tipo, String contrasena) {
		super(nombre, apellido, id, tipo, contrasena);
	}

	
}
