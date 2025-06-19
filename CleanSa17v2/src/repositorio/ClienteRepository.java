package repositorio;
import java.util.List;

import BLL.Cliente;

public interface ClienteRepository {
	<T> T login(String dni, String contrasena);
	 	void agregarCliente();
	    //List<Cliente> mostrarClientes();
		void comprar(int id);
		void carrito(int id);
}
