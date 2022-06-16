
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Menú Principal</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Men&uacute; Principal</h1>
        <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
        <div class="CuadroDeDesarrollador">
            <h4>Desarrollador</h4>
            <h3>Luis González</h3>
            <h4>Curso</h4>
            <h3>Full Stack Java Trainee</h3>
        </div>
    </body>
</html>

