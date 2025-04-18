

public class Empresa extends Cliente {
	private String nro;

	public Empresa(String nombre, String apellido, String direccion, Boolean tipo, String nro) {
		super(nombre, apellido, direccion, tipo);
		this.nro = nro;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}
	

}
