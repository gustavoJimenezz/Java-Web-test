<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>





	<form action=authClientes method="post">

		<p>
			Cliente: <select name="cliente_id">
				<c:forEach var="cliente" items="${clientes}">

					<option value="${cliente.id}">${cliente.nombre}</option>

				</c:forEach>

			</select>
		</p>
		<input type="submit" value="identificarse">






	</form>





</body>
</html>