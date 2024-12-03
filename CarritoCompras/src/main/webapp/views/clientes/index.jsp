<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado Clientes</title>
</head>
<body>

	<a href="clientes?accion=create">Agregar Cliente</a>
	<table border = "1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var ="clientes" items = "${listaCliente}">
				<tr>
					<td><c:out value="${clientes.id}"/></td>
					<td><c:out value="${clientes.nombre}"/></td>
					<td><c:out value="${clientes.apellido}"/></td>
					<td><c:out value="${clientes.saldo}"/></td>
					 <td><a href="clientes?accion=show&id=${clientes.id}">Ver</a></td>
                    <td><a href="clientes?accion=edit&id=${clientes.id}">Editar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>