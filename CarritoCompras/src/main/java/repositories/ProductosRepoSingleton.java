package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Producto;
import repositories.interfaces.ProductoRepo;

public class ProductosRepoSingleton implements ProductoRepo{
	
	private static ProductosRepoSingleton singleton;
	public static ProductosRepoSingleton getInstance() {
		if(singleton == null) {
			singleton = new ProductosRepoSingleton();
		}
		return singleton;
	}
	
	private List<Producto> listaProductos;

	private ProductosRepoSingleton() {
		this.listaProductos = new ArrayList<Producto>();
		Producto producto = new Producto("000", "Arroz", "Granos de arroz finos", 8000);
		Producto producto2 = new Producto("111", "Fideos", "Cabello de angel, el mejor para sopas", 9000);
		Producto producto3= new Producto("222", "Polenta", "Lo mas rapido y facil de a¿hacer para la familia", 10000);
		this.insert(producto);
		this.insert(producto2);
		this.insert(producto3);
		

	}

	@Override
	public List<Producto> getAll() {
		return new ArrayList<Producto>(this.listaProductos);
	}

	@Override
	public Producto findById(int id) {
		return this.listaProductos.stream().filter((e) -> e.getId() == id).findAny().orElse(null);
	}

	@Override
	public void insert(Producto producto) {
		int ultimoId = this.listaProductos.stream().map(Producto::getId).max(Integer::compare).orElse(0);
		producto.setId(ultimoId+1);
		this.listaProductos.add(producto);
		
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		this.listaProductos.removeIf((e) -> e.getId() == id);
	}
	
}
