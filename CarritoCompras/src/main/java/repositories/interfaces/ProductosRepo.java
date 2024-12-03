package repositories.interfaces;

import java.util.List;

import models.Productos;

public interface ProductosRepo {
	public List<Productos> getAll();
	public Productos findById(int id);
	public void insert(Productos productos);
	public void update(Productos productos);
	public void delete(int id);
}
