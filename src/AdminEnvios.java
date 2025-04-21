import javax.swing.JOptionPane;

public class AdminEnvios extends Administrador {

	private String id_envios;

	public AdminEnvios(String nombre, String apellido, String id_envios) {
		super(nombre, apellido);
		this.id_envios = id_envios;
	}

	public String getId_envios() {
		return id_envios;
	}

	public void setId_envios(String id_envios) {
		this.id_envios = id_envios;
	}

	@Override
	public boolean logIn() {
		String numero="";
		numero=JOptionPane.showInputDialog("Ingrese su numero");
		if (numero.equalsIgnoreCase(id_envios)) {
			return true;
		}else {
			
			return false;
		
	}
	
	}
}

