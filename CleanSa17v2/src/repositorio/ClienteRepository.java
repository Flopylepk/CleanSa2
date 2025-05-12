package repositorio;
import java.util.List;

import BLL.Cliente;

public interface ClienteRepository {
	 	void agregarCliente();
	    List<Cliente> mostrarUsuarios();
		<T> T login();
		<T> T validar(String nombre, String contrasena);
}
