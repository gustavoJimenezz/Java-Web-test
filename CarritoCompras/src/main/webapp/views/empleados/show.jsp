<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Empleado</title>
</head>
<body>
<h1>Empleado</h1>
<p>Nombre:<c:out value="${empleado.nombre}"/></p>
<p>Apellido:<c:out value="${empleado.apellido}"/></p>

<form action="empleados" method="post">
		<input type="hidden" name="id" value ="${empleado.id}">
		<input type="hidden" name="accion" value ="delete">
		<input type="submit" value ="Eliminar empleado" >
		<a href="empleados"> Volver al indice</a>
</form>
</body>
</html>