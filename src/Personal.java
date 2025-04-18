
public class Personal extends Cliente{
	private String dni;

	public Personal(String nombre, String apellido, String direccion, Boolean tipo, String dni) {
		super(nombre, apellido, direccion, tipo);
		this.dni = dni;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	

}
