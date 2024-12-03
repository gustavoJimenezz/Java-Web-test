<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Productos</title>
</head>
<body>
	<a href="productos?accion=create">Agregar Producto</a>
	<table border = "1">
		<thead>
			<tr>
				<th>Id</th>
				<!--<th>Codigo Articulo</th>-->
				<th>Nombre Articulo</th>
				<!--<th>Descripcion articulo</th>-->
				<th>Precio articulo</th>
				
				
			</tr>
		</thead>
		<tbody>

			<c:forEach var="producto" items="${listProductos}">
			    <tr>
			    	<td><c:out value="${producto.id}" /></td>
			    	 <!--<td><c:out value="${producto.codArt}" /></td>  -->
			        <td><c:out value="${producto.nombArt}" /></td>
			        <!--<td><c:out value="${producto.descArt}" /></td>-->
			        <td><c:out value="${producto.precio}" /></td>
			        <td><a href="productos?accion=show&id=${producto.id}">Ver</a></td>
                    <td><a href="productos?accion=edit&id=${producto.id}">Editar</a></td>
			        
			    </tr>
			</c:forEach>
			
		</tbody>
	</table>
</body>
</html>