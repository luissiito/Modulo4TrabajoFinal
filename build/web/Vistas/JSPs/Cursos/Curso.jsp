
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
        <title>Curso</title>
    </head>
    <body>
        <h1>Modificar Información del Curso</h1>
         <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
         <main class="Presentacion">  
             <form action="ControladorCurso" class="FormularioDeCurso" method="post">
                 <label for="id">Identificador</label>
                 <input type="text" name="id" value="${curso.getId()}" readonly>
                 <label for="codigo">C&oacute;digo</label>
                 <input type="text" name="codigo" value="${curso.getCodigo()}">
                 <label for="nombre">Nombre</label>
                 <input type="text" name="nombre" value="${curso.getNombre()}">
                 <label for="idFacilitador">Facilitador</label>
                 <input type="text" name="idFacilitador" value="${curso.getIdFacilitador()}">
                 <label for="lastUpdate">Last Update</label>
                 <input type="text" name="lastUpdate" value="${curso.getLastUpdate()}" readonly>
                 <input type="hidden" name="operacion" value="actualizar">
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