<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta Productos</title>
</head>
<body>
<form action="productos" method="post">
	<input type="hidden" value="insert" name ="accion"/>
	<p>Nombre Articulo: <input value = "${producto.nombArt}" name="nombArt"/></p>
	<p>Codigo Articulo: <input value = "${producto.codArt}" name="codArt"/></p>
	<p>Descripcion Articulo: <input value = "${producto.descArt}" name=descArt/></p>
	<p>Precio Articulo:: <input value = "${producto.precio}" name="precio"/></p>
	<input type="submit" value="Crear">
</form>
	
</body>
</html>