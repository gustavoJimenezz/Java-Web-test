<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Producto</title>
</head>
<body>
<h1>Editar</h1>
<form action="productos" method="post">
	<input type="hidden" value="update" name ="accion"/>
	<p>ID: <input value = "${producto.id}" name="id" readonly/></p>
	<p>Codigo Articulo: <input value = "${producto.codArt}" name="codArt"/></p>
	<p>Nombre Articulo: <input value = "${producto.nombArt}" name="nombArt"/></p>
	<p>Descripcion Articulo: <input value = "${producto.descArt}" name="descArt"/></p>
	<p>Precio Articulo: <input value = "${producto.precio}" name="precio"/></p>
	<input type="submit" value="Editar">	
</form>

</body>
</html>