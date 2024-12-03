package controllers;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Cliente;
import utils.CompraBuilder;

@WebServlet("/CreacionCompraController")
	public class CreacionCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreacionCompraController() {
		super();
	}
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		
		 
		 Cliente clienteLogNullable = (Cliente) session.getAttribute("cliente");
		Cliente clienteLog = Optional.ofNullable(clienteLogNullable).orElseThrow(() -> new IOException("No hay  usuario"));
		 
		 
		// compra =Optional.ofNullable(compra).orElse(new CompraBuilder(clienteLog));
		 CompraBuilder compra = (CompraBuilder) session.getAttribute("compra");
		  
		 compra = Optional.ofNullable(compra).orElseGet(   () ->{
			CompraBuilder comp = new CompraBuilder(clienteLog);
			session.setAttribute("compra", comp);
			return comp; 
		 });
		 session.setAttribute("compra", compra);
		 request.setAttribute("compra", compra);
		 
	
		 request.getRequestDispatcher("/views/creacionCompra/index.jsp").forward(request, response);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 String accion =request.getParameter("accion");
		 
		 switch (accion) {
		 	case "modifcompra" -> doModificarPresupuesto(request,response);
		 	default -> response.sendError(404);
		}
		 
		 
}
	private void doModificarPresupuesto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		HttpSession session = request.getSession();
		
		
		CompraBuilder compra = (CompraBuilder) session.getAttribute("compra");
		
		 
		 Cliente clienteLogNullable = (Cliente) session.getAttribute("cliente");
		Cliente clienteLog = Optional.ofNullable(clienteLogNullable).orElseThrow(() -> new IOException("No hay  usuario"));
		  
		 compra = Optional.ofNullable(compra).orElseGet(   () ->{
			CompraBuilder comp = new CompraBuilder(clienteLog);
			session.setAttribute("compra", comp);
			return comp; 
		 });
		 
		 String sSaldo = request.getParameter("saldo");
		 double saldo = Double.parseDouble(sSaldo);
		 
		 compra.setSaldo(serialVersionUID);
		 
		 response.sendRedirect("crear");
	}











}
