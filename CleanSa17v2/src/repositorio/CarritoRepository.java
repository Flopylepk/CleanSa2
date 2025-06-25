package repositorio;

import java.util.LinkedList;
import java.util.List;

import BLL.*;


public interface CarritoRepository {
	
	String pagar(int id);
	String cancelar(int id);
	
}
