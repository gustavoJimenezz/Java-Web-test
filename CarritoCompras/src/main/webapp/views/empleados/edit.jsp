<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Empleado</title>
</head>
<body>
<h1>Editar</h1>
<form action="empleados" method="post">
<input type="hidden" value="update" name ="accion"/>
	<p>ID: <input value = "${empleado.id}" name="id" readonly/></p>
	<p>Nombre: <input value = "${empleado.nombre}" name="nombre"/></p>
	<p>Apellido: <input value = "${empleado.apellido}" name="apellido"/></p>
	<p>Contrasenia: <input value = "${empleado.contra}" name="contrasenia"/></p>
	<p>Repetir Contrasenia: : <input value = "${empleado.confirmContra}" name="confirmarContrasenia"/></p>
	<input type="submit" value="Editar"/>
</form>
</body>
</html>