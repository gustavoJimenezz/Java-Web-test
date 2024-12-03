package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import factory.RepoFactory;
import models.Cliente;
import repositories.interfaces.ClienteRepo;



@WebServlet("/clientes")
public class ClientesController extends HttpServlet {
private static final long serialVersionUID = 1L;
private ClienteRepo repo;

    public ClientesController() {
        RepoFactory factory = new RepoFactory();
        this.repo = factory.getClienteRepo();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        accion = Optional.ofNullable(accion).orElse("index");

        switch (accion) {
            case "index":
                getIndex(request, response);
                break;
            case "show":
                getShow(request, response);
                break;
            case "edit":
                getEdit(request, response);
                break;
            case "create":
                getCreate(request, response);
                break;
            default:
                response.sendError(404);
                break;
        }
    }



private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
List<Cliente> lCliente = repo.getAll();
request.setAttribute("listaCliente", lCliente);
request.getRequestDispatcher("/views/clientes/index.jsp").forward(request, response);
}

private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id")) ;
Cliente cliente =  repo.findById(id);
request.setAttribute("clientes", cliente);
request.getRequestDispatcher("/views/clientes/show.jsp").forward(request, response);
}

private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("/views/clientes/create.jsp").forward(request, response);
}

private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id")) ;
Cliente cliente =  repo.findById(id);
request.setAttribute("clientes", cliente);
request.getRequestDispatcher("/views/clientes/edit.jsp").forward(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String accion = request.getParameter("accion");
	if (accion ==null) {
		response.sendError(400, "No se brindó un accion.");
		return;
	}
	
	switch (accion) {
	case "insert":
			postInsert(request,response);
		break;
	case "update":
		postUpdate(request,response);
		break;
	case "delete":
		postDelete(request,response);
	break;

	default:
		response.sendError(404, "No existe la accion: "+accion);
		break;
	}
	
	
}

private void postDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String sId =request.getParameter("id");
	int id = Integer.parseInt(sId);
	
	repo.delete(id);
	response.sendRedirect("clientes");
	
}

private void postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String sId =request.getParameter("id");
	int id = Integer.parseInt(sId);
	String sSaldo =request.getParameter("saldo");
	double saldo =Double.parseDouble(sSaldo);
	
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String contrasenia = request.getParameter("contrasenia");
	Cliente cliente = repo.findById(id);
	cliente.setNombre(nombre);
	cliente.setApellido(apellido);
	cliente.setContra(contrasenia);
	cliente.setSaldo(saldo);
	repo.update(cliente);
	response.sendRedirect("clientes");
	
} 


private void postInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String sSaldo =request.getParameter("saldo");
	double saldo =Double.parseDouble(sSaldo);
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String contrasenia = request.getParameter("contrasenia");


	
	Cliente cliente = new Cliente(nombre, apellido, contrasenia, saldo);
	repo.insert(cliente);
	response.sendRedirect("clientes");
	
}

}