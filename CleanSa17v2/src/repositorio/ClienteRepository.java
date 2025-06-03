package repositorio;
import java.util.List;

import BLL.Cliente;

public interface ClienteRepository {
	 	void agregarCliente();
	   
		<T> T login();
		<T> T validar(String nombre);
		void comprar(int id);
		void carrito(int id);
}
