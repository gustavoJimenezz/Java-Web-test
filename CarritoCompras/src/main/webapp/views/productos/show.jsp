<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Producto </title>
</head>
<body>
<h1>Producto</h1>
    <p>Código artículo: <c:out value="${producto.codArt}" /></p>
    <p>Nombre artículo: <c:out value="${producto.nombArt}" /></p>
    <p>Descripción artículo: <c:out value="${producto.descArt}" /></p>
    <p>Precio artículo: $<c:out value="${producto.precio}" /></p>
    <form action="productos" method="post">
		<input type="hidden" name="id" value ="${producto.id}">
		<input type="hidden" name="accion" value ="delete">
		<input type="submit" value ="Eliminar producto" >
</form>
</body>
</html>