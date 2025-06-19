package repositorio;
import java.util.List;

import BLL.Cliente;

public interface ClienteRepository {
	 	void agregarCliente();
<<<<<<< HEAD:CleanSa17v2/src/repositorio/ClienteRepository.java
	   
		<T> T login();
=======
	    List<Cliente> mostrarClientes();
		<T> T login(String dni, String contrasena);
>>>>>>> origin/Gero:CleanSa17v2/repositorio/ClienteRepository.java
		<T> T validar(String nombre);
		void comprar(int id);
		void carrito(int id);
}
