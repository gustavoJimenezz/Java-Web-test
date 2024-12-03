package repositories.interfaces;

import java.util.List;

import models.Cliente;

public interface ClienteRepo {
	public List<Cliente> getAll();
	public Cliente findById(int id);
	public void insert(Cliente cliente);
	public void update(Cliente cliente);
	public void delete(int id);
}
