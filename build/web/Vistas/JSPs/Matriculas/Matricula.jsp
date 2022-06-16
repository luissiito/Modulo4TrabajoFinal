
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
        <title>Matrícula</title>
    </head>
    <body>
        <h1>Modificar Información de la Matr&iacute;cula</h1>
         <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
         <main class="Presentacion"> 
             <form action="ControladorMatricula" class="FormularioDeMatricula" method="post">
                 <label for="idEstudiante">Id Estudiante</label>
                 <input name="idEstudiante" type="text"  value="${matricula.getIdEstudiante()}">
                 <label for="idCurso">Id Curso</label>
                 <input name="idCurso" type="text" value="${matricula.getIdCurso()}">
                 <label for="fecha">Fecha</label>
                 <input name="fecha" type="text" value="${matricula.getFecha()}">
                 <label for="lastUpdate">Last Update</label>
                 <input name="lastUpdate" type="text" value="${matricula.getLastUpdate()}">
                 <input type="hidden" name="operacion" value="actualizar">
                 <input type="hidden" name="idEstudiante" value="${matricula.getIdEstudiante()}">
                 <input type="submit"  value="Enviar Modificación">
             </form>
        </main>
        <script>
            let CuadroInformativo = document.createElement('h3');
            CuadroInformativo.innerHTML = ${resultadoOperacionUpdate} != ''? '<p style="color:green; margin-top:0.5em;">MODIFICACIÓN EXITOSA</p>': '<p style="color:red; margin-top:0.5em;">HUBO PROBLEMAS AL INTENTAR LA MODIFICACIÓN</p>';
            document.querySelector('main').before(CuadroInformativo);
        </script>
        <script src="${pageContext.request.contextPath}/Scripts/barraLateral.js" type="text/javascript"></script>
    </body>
</html>