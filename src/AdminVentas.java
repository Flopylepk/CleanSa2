

public class AdminVentas extends Administrador implements Validador {
	
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
	
	public boolean logIn(AdminVentas ventas) {
		String numero="";
		numero=ventas.validarCaracteres("Ingrese su numero");
		if (numero.equalsIgnoreCase(id_ventas)) {
			return true;
		}else {
			
			return false;
		}
	
	
	
	

	}

}
