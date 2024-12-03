package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import repositories.interfaces.ClienteRepo;

public class ClientesRepoSingleton implements ClienteRepo{
private static ClientesRepoSingleton singleton;
	
	public static ClientesRepoSingleton getInstance() {
		if(singleton == null) {
			singleton = new ClientesRepoSingleton();
		}
		return singleton;
	}
	
	private List<Cliente> listaClientes;

	private ClientesRepoSingleton() {
		this.listaClientes = new ArrayList<Cliente>();
		Cliente cliente = new Cliente("Franco", "Seccas", "123", 900000);
		Cliente cliente2 = new Cliente("Lucas", "Aguirre", "123", 950000);
		Cliente cliente3= new Cliente("Tomas", "Lanza", "123", 100000);
		this.insert(cliente);
		this.insert(cliente2);
		this.insert(cliente3);
		

	}

	@Override
	public List<Cliente> getAll() {
		return new ArrayList<Cliente>(this.listaClientes);
	}

	@Override
	public Cliente findById(int id) {
		return this.listaClientes.stream().filter((e) -> e.getId() == id).findAny().orElse(null);
	}

	@Override
	public void insert(Cliente cliente) {
		int ultimoId = this.listaClientes.stream().map(Cliente::getId).max(Integer::compare).orElse(0);
		cliente.setId(ultimoId+1);
		this.listaClientes.add(cliente);
		
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		this.listaClientes.removeIf((e) -> e.getId() == id);
	}
	
}
