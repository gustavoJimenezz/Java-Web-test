<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>





<form action="authEmpleados" method="post">

<p>
	Empleado: <select name="empleado_id">
	<c:forEach var="empleado" items="${empleados}">
	
		<option value="${empleado.id}"> ${empleado.nombre}</option>
	
	</c:forEach>

	</select>
</p>
<input type="submit" value="identificarse">






</form>





</body>
</html>