package factory;

import repositories.ClientesRepoSingleton;
import repositories.EmpleadosRepoSingleton;
import repositories.ProductosRepoSingleton;
import repositories.interfaces.ClienteRepo;
import repositories.interfaces.EmpleadoRepo;
import repositories.interfaces.ProductoRepo;

public class RepoFactory {
	
	
	public EmpleadoRepo getEmpleadoRepo() {
		return EmpleadosRepoSingleton.getInstance();
	}
	public ProductoRepo getProductoRepo() {
		return ProductosRepoSingleton.getInstance();
	}
	public ClienteRepo getClienteRepo() {
		
		return ClientesRepoSingleton.getInstance();
	}
}
