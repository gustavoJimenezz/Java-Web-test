<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Alta Clientes</h1>
<form action="clientes" method="post">
<input type="hidden" value="insert" name ="accion"/>
	<p>Nombre: <input value = "" name="nombre"/></p>
	<p>Apellido: <input value = "" name="apellido"/></p>
	<p>Contrasenia: <input value = "" name="contrasenia"/></p>
	<p>Saldo: $ <input value = "" name="saldo"/></p>
	<input type="submit" value="Crear">
</form>
</body>
</html>
