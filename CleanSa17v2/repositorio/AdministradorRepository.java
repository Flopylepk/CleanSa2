package repositorio;

<<<<<<< HEAD:CleanSa17v2/repositorio/AdministradorRepository.java
public interface AdministradorRepository {
	<T> T login();
	
=======
import BLL.Administrador;

public interface AdministradorRepository<T extends Administrador> {

	T login();
    

>>>>>>> abril:CleanSa17v2/src/repositorio/AdministradorRepository.java
}


