
public class AdminVentas extends Administrador {
	
	private String id_ventas;
	public AdminVentas(String nombre, String apellido, String id_ventas) {
		super(nombre, apellido);
		this.id_ventas = id_ventas;
	}
	public String getId_ventas() {
		return id_ventas;
	}
	public void setId_ventas(String id_ventas) {
		this.id_ventas = id_ventas;
	}
	@Override
	public void logIn() {
		// TODO Auto-generated method stub
		super.logIn();
	}
	
	
	
	

	

}
