<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Cliente</title>
</head>
<body>
<h1>Clientes</h1>
<p>Nombre:<c:out value="${clientes.nombre}"/></p>
<p>Apellido:<c:out value="${clientes.apellido}"/></p>
<p>Saldo: $<c:out value="${clientes.saldo}"/></p>


<form action="clientes" method="post">
		<input type="hidden" name="id" value ="${clientes.id}">
		<input type="hidden" name="accion" value ="delete">
		<input type="submit" value ="Eliminar cliente" >
</form>
</body>
</html>