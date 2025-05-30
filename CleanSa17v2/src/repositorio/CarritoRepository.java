package repositorio;

import java.util.List;

import BLL.*;


public interface CarritoRepository {
	List<Carrito> mostrarCarrito();
	List<Carrito> mostrarCarritoEnProseso();
	List<Carrito> mostrarCarritosPagados();
	List<Carrito> mostrarCarritoCancelados();
	List<Carrito> mostrarCarritoporCliente(int id);
	List<Carrito> mostrarCarritoporClienteEnProseso(int id);
	List<Carrito> mostrarCarritoporClientePagados(int id);
	List<Carrito> mostrarCarritoporClienteCancelados(int id);
	void pagar(int id);
	void cancelar(int id);
}
