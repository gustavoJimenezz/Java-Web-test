package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Empleado;
import repositories.interfaces.EmpleadoRepo;

public class EmpleadosRepoSingleton implements EmpleadoRepo{
	
	private static EmpleadosRepoSingleton singleton;
	
	public static EmpleadosRepoSingleton getInstance() {
		if(singleton == null) {
			singleton = new EmpleadosRepoSingleton();
		}
		return singleton;
	}
	
	private List<Empleado> listaEmpleados;

	private EmpleadosRepoSingleton() {
		this.listaEmpleados = new ArrayList<Empleado>();
		Empleado empleado = new Empleado("Franco", "Seccas", "123");
		Empleado empleado2 = new Empleado("Lucas", "Aguirre", "123");
		Empleado empleado3 = new Empleado("Tomas", "Lanza", "123");
		Empleado empleado4 = new Empleado("Gustavo", "Gimenez", "123");
		Empleado empleado5 = new Empleado("Niglio", "Gabriel", "123");
		this.insert(empleado);
		this.insert(empleado2);
		this.insert(empleado3);
		this.insert(empleado4);
		this.insert(empleado5);
	}

	@Override
	public List<Empleado> getAll() {
		return new ArrayList<Empleado>(this.listaEmpleados);
	}

	@Override
	public Empleado findById(int id) {
		return this.listaEmpleados.stream().filter((e) -> e.getId() == id).findAny().orElse(null);
	}

	@Override
	public void insert(Empleado empleado) {
		int ultimoId = this.listaEmpleados.stream().map(Empleado::getId).max(Integer::compare).orElse(0);
		empleado.setId(ultimoId+1);
		this.listaEmpleados.add(empleado);
		
	}

	@Override
	public void update(Empleado empleado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		this.listaEmpleados.removeIf((e) -> e.getId() == id);
	}
}
