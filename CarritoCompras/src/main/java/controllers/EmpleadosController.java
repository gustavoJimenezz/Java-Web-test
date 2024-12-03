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
import models.Empleado;
import repositories.interfaces.EmpleadoRepo;


@WebServlet("/empleados")
public class EmpleadosController extends HttpServlet {
private static final long serialVersionUID = 1L;
private EmpleadoRepo repo;

    public EmpleadosController() {
        RepoFactory factory = new RepoFactory();
        this.repo = factory.getEmpleadoRepo();
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
List<Empleado> lEmpleado = repo.getAll();
request.setAttribute("listEmpleados", lEmpleado);
request.getRequestDispatcher("/views/empleados/index.jsp").forward(request, response);
}

private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id")) ;
Empleado emple =  repo.findById(id);
request.setAttribute("empleado", emple);
request.getRequestDispatcher("/views/empleados/show.jsp").forward(request, response);
}

private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("/views/empleados/create.jsp").forward(request, response);
}

private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id")) ;
Empleado emple =  repo.findById(id);
request.setAttribute("empleado", emple);
request.getRequestDispatcher("/views/empleados/edit.jsp").forward(request, response);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String accion = request.getParameter("accion");
	if (accion ==null) {
		response.sendError(400, "No se brindó un accion.");
		return;
	}
	//accion = Optional.ofNullable(accion).orElse("insert");
	
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
	response.sendRedirect("empleados");
	
}

private void postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String sId =request.getParameter("id");
	int id = Integer.parseInt(sId);
	
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String contrasenia = request.getParameter("contrasenia");
	Empleado emple = repo.findById(id);
	emple.setNombre(nombre);
	emple.setApellido(apellido);
	emple.setContra(contrasenia);
	repo.update(emple);
	response.sendRedirect("empleados");
	
} 


private void postInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String contrasenia = request.getParameter("contrasenia");
	Empleado emple = new Empleado(nombre, apellido, contrasenia);
	repo.insert(emple);
	response.sendRedirect("empleados");
	
}

}