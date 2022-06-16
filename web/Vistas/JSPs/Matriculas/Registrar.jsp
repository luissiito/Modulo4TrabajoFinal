<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Matr&iacute;cula</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>        
        <h1>Registrar Nueva Matr&iacute;cula</h1>
         <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
         <main class="Presentacion">
               <form action="${pageContext.request.contextPath}/ControladorMatricula" class="FormularioDeMatricula" method="post">
                 <label for="idEstudiante">Id Estudiante</label>
                 <input class="FrmDeRegistro" name="idEstudiante" type="text" required>
                 <label for="idCurso">Id Curso</label>
                 <input name="idCurso" type="text" required>
                 <label for="fecha">Fecha</label>
                 <input name="fecha" type="text" readonly/>
                 <label for="lastUpdate">Last Update</label>
                 <input class="FrmDeRegistro" name="lastUpdate" type="text" readonly>
                 <input type="hidden" name="operacion" value="insertar">
                 <input type="submit"  value="Registrar Matrícula">
             </form>
        </main>
        <script src="../../../Scripts/main.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Scripts/barraLateral.js" type="text/javascript"></script>
    </body>
</html>
