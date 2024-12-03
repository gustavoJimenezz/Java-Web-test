package models;

import java.util.List;

public class Venta {

	private int clienteId;
	private int id;
	private double saldo;
	private double total;
	
	//realacion

	private List<Detalle_Compra> venta;

	public Venta(int clienteId, double saldo, double total) {
		super();
		this.clienteId = clienteId;
		this.saldo = saldo;
		this.total = total;
	}
	public void addVenta(int clienteId, String listadoProd, double saldo) {
		
	}
	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Detalle_Compra> getVenta() {
		return venta;
	}
 

	

	
	
	
}
