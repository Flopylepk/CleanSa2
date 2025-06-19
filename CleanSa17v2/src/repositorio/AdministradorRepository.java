package repositorio;

import BLL.Administrador;

public interface AdministradorRepository<T extends Administrador> {

	T login();
    

}


