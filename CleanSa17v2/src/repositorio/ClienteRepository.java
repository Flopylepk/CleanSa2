package repositorio;
import java.util.List;

import BLL.Cliente;

public interface ClienteRepository {
	 	void agregarCliente();
	    List<Cliente> mostrarClientes();
		<T> T login(String dni, String contrasena);
		void carrito(int id);
}
