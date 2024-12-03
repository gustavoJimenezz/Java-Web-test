<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comprar!!</title>
</head>
<body>

<h1>Bienvenido al carrito online</h1>

<p>CLiente: $
	<c:out value="${compra.comprador.nombre}"/>
</p>


<p>Compra: $
	<c:out value="${compra.saldo }"/>
</p>

<h3>Cambiar Compra</h3>
<form action="crear" method="post">
	<input type="hidden" value="modifcompra" name="accion">
	<input name="importe">
	<input type="submit">
</form>

</body>
</html>