package utils;

import java.io.IOException;

import exceptions.SaldoExcedidoException;
import models.Cliente;
import models.Venta;
import repositories.interfaces.ClienteRepo;

public class CompraBuilder {

	private Cliente comprador;
	private double saldo;
	
	public CompraBuilder (Cliente comprador) {
		
		super();
		this.comprador = comprador;
		this.saldo = saldo;
		
		
	}

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Venta toVenta(ClienteRepo cRepo, int clienteId) throws IOException, SaldoExcedidoException {
		
		Venta venta = new Venta(clienteId, saldo, this.getTotal());
		
		//---- ACA EL PROFE HACE UN FOR DE TUPLAS PARA RECORRER LOS PROYECTOS----
		
		//Condicional para validar que el total del saldo es mayor al total de la compra
		if(this.saldo < this.getTotal()) {
			throw new SaldoExcedidoException("El saldo presente no es suficiente");
		}
		
		
		return null;
		
	}

	
}
