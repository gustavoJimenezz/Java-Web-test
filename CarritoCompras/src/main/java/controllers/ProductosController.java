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
import models.Producto;
import repositories.interfaces.ProductoRepo;

@WebServlet("/productos")
public class ProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoRepo repo;
       
    public ProductosController() {
    	RepoFactory factory = new RepoFactory();
        this.repo = factory.getProductoRepo();
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
				
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Producto> lProducto = repo.getAll();
		request.setAttribute("listProductos", lProducto);
		request.getRequestDispatcher("/views/productos/index.jsp").forward(request, response);
	}

	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		Producto prod =  repo.findById(id);
		request.setAttribute("producto", prod);	
		request.getRequestDispatcher("/views/productos/show.jsp").forward(request, response);
	}

	private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/productos/create.jsp").forward(request, response);
	}

	private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")) ;
		Producto prod =  repo.findById(id);
		request.setAttribute("producto", prod);	
		request.getRequestDispatcher("/views/productos/edit.jsp").forward(request, response);
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
	response.sendRedirect("productos");
	
}

private void postUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String sId = request.getParameter("id");
    int id = Integer.parseInt(sId);;
    String codArt = request.getParameter("codArt");
    String nombArt = request.getParameter("nombArt");
    String descArt = request.getParameter("descArt");
    String precioStr = request.getParameter("precio");
    double precio;
    try {
        precio = Double.parseDouble(precioStr);
    } catch (NumberFormatException e) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El precio proporcionado no es válido.");
        return;
    }
    Producto produ = repo.findById(id);
    if (produ == null) {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "El producto con el ID especificado no existe.");
        return;
    }
    produ.setCodArt(codArt);
    produ.setNombArt(nombArt);
    produ.setDescArt(descArt);
    produ.setPrecio(precio);
    repo.update(produ);
    response.sendRedirect("productos");
}



private void postInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String codArt = request.getParameter("codArt");
    String nombArt = request.getParameter("nombArt");
    String descArt = request.getParameter("descArt");
    String precioStr = request.getParameter("precio");
    double precio;
    try {
        precio = Double.parseDouble(precioStr);
    } catch (NumberFormatException e) {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El precio proporcionado no es válido.");
        return;
    }
	Producto produ = new Producto(codArt, nombArt, descArt, precio);
	repo.insert(produ);
	response.sendRedirect("productos");
	
}

}
