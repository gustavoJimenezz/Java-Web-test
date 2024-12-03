<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Cliente</title>
</head>
<body>
<h1>Editar</h1>
<form action="clientes" method="post">
<input type="hidden" value="update" name ="accion"/>
	<p>ID: <input value = "${clientes.id}" name="id" readonly/></p>
	<p>Nombre: <input value = "${clientes.nombre}" name="nombre"/></p>
	<p>Apellido: <input value = "${clientes.apellido}" name="apellido"/></p>
	<p>Contrasenia: <input value = "${clientes.contra}" name="contrasenia"/></p>
	<p>Saldo: $ <input value = "${clientes.saldo}" name="saldo"/></p>
	<input type="submit" value="Editar">
</form>
</body>
</html>