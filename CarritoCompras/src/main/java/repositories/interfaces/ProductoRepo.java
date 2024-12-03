package repositories.interfaces;

import java.io.IOException;
import java.util.List;

import models.Producto;

public interface ProductoRepo {
	public List<Producto> getAll()throws IOException;
	public Producto findById(int id)throws IOException;
	public void insert(Producto producto) throws IOException;
	public void update(Producto producto) throws IOException;
	public void delete(int id) throws IOException ;
}
