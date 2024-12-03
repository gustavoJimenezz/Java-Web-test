<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Empleados</title>
</head>
<body>
		<h1> Bienvenido <c:out value="${sessionScope.empleado.nombre}" default="a la Lista Empleados"></c:out> </h1>
		<a href="empleados?accion=create">Agregar Empleado</a>
    <table border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="empleado" items="${listEmpleados}">
                <tr>
                    <td><c:out value="${empleado.id}"/></td>
                    <td><c:out value="${empleado.nombre}"/></td>
                    <td><c:out value="${empleado.apellido}"/></td>
                    <td><a href="empleados?accion=show&id=${empleado.id}">Ver</a></td>
                    <td><a href="empleados?accion=edit&id=${empleado.id}">Editar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
