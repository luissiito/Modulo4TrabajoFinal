
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Curso</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>        
        <h1>Registrar Nuevo Curso</h1>
         <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
         <main class="Presentacion">
              <form action="${pageContext.request.contextPath}/ControladorCurso" class="FormularioDeCurso" method="post">
                 <label for="codigo">C&oacute;digo</label>
                 <input class="FrmDeRegistro" type="text" name="codigo" required="">
                 <label for="nombre">Nombre</label>
                 <input type="text" name="nombre" required>
                 <label for="idFacilitador">Facilitador</label>
                 <input type="text" name="idFacilitador">
                 <label for="lastUpdate">Last Update</label>
                 <input class="FrmDeRegistro" name="lastUpdate" type="text" readonly>
                 <input type="hidden" name="operacion" value="insertar">
                 <input type="submit"  value="Registrar Curso">
             </form>
        </main>
        <script src="../../../Scripts/main.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Scripts/barraLateral.js" type="text/javascript"></script>
    </body>
</html>
