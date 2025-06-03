package repositorio;

import java.util.List;

import BLL.*;


public interface CarritoRepository {
	
	void pagar(int id);
	void cancelar(int id);
}
