package repositorio;
import java.util.List;

import BLL.Cliente;

public interface ClienteRepository {
	<T> T login(String dni, String contrasena);
	 	void agregarCliente();
<<<<<<< HEAD:CleanSa17v2/src/repositorio/ClienteRepository.java
	    //List<Cliente> mostrarClientes();
=======
	    List<Cliente> mostrarClientes();
		<T> T login(String dni, String contrasena);
>>>>>>> main:CleanSa17v2/repositorio/ClienteRepository.java
		void comprar(int id);
		void carrito(int id);
}
