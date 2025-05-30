package repositorio;

import java.util.List;

import BLL.*;

public interface DetalleRepository {
	List<Pedido> mostrarCarrito_detalle(int id_carrito);
}
