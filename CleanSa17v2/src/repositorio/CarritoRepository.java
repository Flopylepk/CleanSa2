package repositorio;

import java.util.List;

import BLL.*;


public interface CarritoRepository {
	List<Carrito> mostrarCarrito();
	List<Carrito> mostrarCarritoporCliente(int id);
}
