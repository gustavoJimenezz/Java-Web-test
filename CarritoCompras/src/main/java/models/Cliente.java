package models;

public class Cliente {
	private int id;
	private String nombre;
	private String apellido;
	private String contra;
	private double saldo;
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", contra=" + contra + ", saldo=" + saldo + "]";
	}

	public Cliente(String nombre, String apellido, String contra, double saldo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.contra = contra;
		this.saldo = saldo;
	}
	
	public Cliente() {
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
