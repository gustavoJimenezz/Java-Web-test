package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.RepoFactory;
import models.Cliente;
import repositories.interfaces.ClienteRepo;


@WebServlet("/authClientes")
public class AuthControllerClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteRepo repo;

    public AuthControllerClientes() {
       RepoFactory factory = new RepoFactory();
       this.repo = factory.getClienteRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Cliente> clientes = repo.getAll();
		request.setAttribute("clientes", clientes);
		
		
		request.getRequestDispatcher("/views/auth/loginCliente.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("cliente_id");
		int id = Integer.parseInt(sId);
		
		Cliente cliente = repo.findById(id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("cliente", cliente);
		
		response.sendRedirect("clientes");
	}

}
