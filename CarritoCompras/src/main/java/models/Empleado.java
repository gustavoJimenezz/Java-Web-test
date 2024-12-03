package models;

public class Empleado {
	private int id;
	private String nombre;
	private String apellido;
	private String contra;

	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", contra=" + contra
				+"]";
	}

	public Empleado(String nombre, String apellido, String contra) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.contra = contra;

	}
	
	public Empleado() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}


	
	
}
