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
import models.Empleado;
import repositories.interfaces.EmpleadoRepo;

//// TODO cambiar las rutas
@WebServlet("/authEmpleados")
public class AuthControllerEmpleados extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmpleadoRepo repo;

    public AuthControllerEmpleados() {
       RepoFactory factory = new RepoFactory();
       this.repo = factory.getEmpleadoRepo();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Empleado> empleados = repo.getAll();
		request.setAttribute("empleados", empleados);
		
		
		request.getRequestDispatcher("/views/auth/loginEmpleado.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("empleado_id");
		int id = Integer.parseInt(sId);
		
		Empleado emple = repo.findById(id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("empleado", emple);
		
		response.sendRedirect("empleados");
	}

}
