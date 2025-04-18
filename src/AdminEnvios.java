
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
	public void logIn() {
		// TODO Auto-generated method stub
		super.logIn();
	}
	
	
}
