package repositorio;
import java.util.List;

import BLL.Cliente;

public interface ClienteRepository {
	 	void agregarCliente();
	    List<Cliente> mostrarClientes();
		<T> T login();
		<T> T validar(String nombre);
		void comprar(int id);
}
