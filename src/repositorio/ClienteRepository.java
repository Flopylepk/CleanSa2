package repositorio;

import java.util.List;

public interface ClienteRepository {
	 void agregarCliente();
	    List<Cliente> mostrarUsuarios();
		<T> T login();
}
