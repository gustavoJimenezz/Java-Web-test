package models;

public class Detalle_Compra {

	private int id;
	private int ventaId;
	private int clienteId;
	private String listadoProd;
	private double saldo;
	
	
	
	public Detalle_Compra(int clienteId, String listadoProd, double saldo) {
		super();
		this.clienteId = clienteId;
		this.listadoProd = listadoProd;
		this.saldo = saldo;
	}
	
	
	
	public Detalle_Compra() {
		super();
	}







	public double getSaldo() {
		return saldo;
	}



	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVentaId() {
		return ventaId;
	}
	public void setVentaId(int ventaId) {
		this.ventaId = ventaId;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getListadoProd() {
		return listadoProd;
	}
	public void setListadoProd(String listadoProd) {
		this.listadoProd = listadoProd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
