import javax.swing.JOptionPane;

public class Empresa extends Cliente {
	private String nro;

	public Empresa(String nombre, String apellido,String contrasena ,String direccion,String nro ,Boolean tipo) {
		super(nombre, apellido, contrasena ,direccion);
		this.nro = nro;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	@Override
	public void Registro_Cliente(Cliente cliente) {
		String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
	 	String apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido:");
	 	String contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
		String direccion = JOptionPane.showInputDialog(null, "Ingrese su dirección:");
		String nro = JOptionPane.showInputDialog(null, "Ingrese su CUIT:");
		Boolean tipo = true;
		Empresa nuevoClienteE = new Empresa(nombre, apellido,contrasena,direccion,nro,tipo);
		Cliente.getClientes().add(nuevoClienteE);
	}
	
	

}
