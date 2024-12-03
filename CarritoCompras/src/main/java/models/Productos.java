package models;

public class Productos {
	private int id;
	private String codArt;
	private String nombArt;
	private String descArt;
	private double precio;
	
	
	@Override
	public String toString() {
		return "Productos [id=" + id + ", codArt=" + codArt + ", nombArt=" + nombArt + ", descArt=" + descArt
				+ ", precio=" + precio + "]";
	}


	public Productos(String codArt, String nombArt, String descArt, double precio) {
		super();
		this.codArt = codArt;
		this.nombArt = nombArt;
		this.descArt = descArt;
		this.precio = precio;
	}
	
	public Productos() {
		super();
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCodArt() {
		return codArt;
	}


	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}


	public String getNombArt() {
		return nombArt;
	}


	public void setNombArt(String nombArt) {
		this.nombArt = nombArt;
	}


	public String getDescArt() {
		return descArt;
	}


	public void setDescArt(String descArt) {
		this.descArt = descArt;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
