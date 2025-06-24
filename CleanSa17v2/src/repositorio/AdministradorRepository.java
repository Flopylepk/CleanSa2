package repositorio;

public interface AdministradorRepository {
	<T> T logIn();

	<T> T logIn(String nombre, String contrasena);
	
	
}


