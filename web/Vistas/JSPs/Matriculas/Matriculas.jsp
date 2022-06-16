
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
        <title>Matr&iacute;culas</title>
    </head>
    <body>
        <h1>Matr&iacute;culas</h1>
        <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
        <a class="Nuevo" href="${pageContext.request.contextPath}/Vistas/JSPs/Matriculas/Registrar.jsp">+ NUEVA MATR&Iacute;CULA</a>
        <main>           
            <c:forEach var="matricula" items="${Matriculas}">
                <div class="CuadroDeMatricula">
                    <form action="${pageContext.request.contextPath}/ControladorMatricula" method="post">
                        <input type="hidden" name="operacion" value="eliminar">
                        <input type="hidden" name="idEstudiante" value="${matricula.getIdEstudiante()}">
                        <input type="hidden" name="idCurso" value="${matricula.getIdCurso()}">
                        <input type="submit" value="x">
                    </form>
                    <h5>Id Estudiante</h5>
                    <h4>${matricula.getIdEstudiante()}</h4>
                    <h5>Id Curso</h5>
                    <h4>${matricula.getIdCurso()}</h4>
                    <h5>Fecha</h5>
                    <h4>${matricula.getFecha()}</h4>
                    <h5>Last Update</h5>
                    <h4>${matricula.getLastUpdate()}</h4>
                </div>
            </c:forEach>
            <input type="hidden" name="nombreDeExcepcionSQL" value="${nombreDeExcepcionSQL}">
            <input type="hidden" name="mensajeDeExcepcionSQL" value="${mensajeDeExcepcionSQL}">
        </main>
        <script>
            let CuadrosDeMatriculas = document.querySelectorAll('.CuadroDeMatricula');
            let CuadroInformativo = document.createElement('h3');
            for(let c of CuadrosDeMatriculas){
                c.addEventListener('click', ()=> window.location.href = "${pageContext.request.contextPath}/ControladorMatricula?operacion=presentarInformacion&id=" + c.children[2].textContent);
            }
        </script> 
        <script>
            if((${resultadoOperacionInsertar} + 1) == 2){
                CuadroInformativo.innerHTML = (${resultadoOperacionInsertar}) == 1? '<p style="color:green; margin-top:0.5em;">MATR&Iacute;CULA REGISTRADA EXITOSAMENTE</p>': '<p style="color:red; margin-top:0.5em;">HUBO PROBLEMAS AL REGISTRAR MATR&Iacute;CULA</p>';
            }
            document.querySelector('main').before(CuadroInformativo);
        </script>  
        <script>
            if((${resultadoOperacionEliminar} + 1) == 2){
                CuadroInformativo.innerHTML = (${resultadoOperacionEliminar}) == 1? '<p style="color:orange; margin-top:0.5em;">MATR&Iacute;CULA ELIMINADA EXITOSAMENTE</p>': '<p style="color:red; margin-top:0.5em;">HUBO PROBLEMAS AL ELIMINAR MATR&Iacute;CULA</p>';
            }
            document.querySelector('main').before(CuadroInformativo);
        </script>  
        <script src="${pageContext.request.contextPath}/Scripts/barraLateral.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Scripts/excepcionesMatriculas.js" type="text/javascript"></script>
    </body>
</html>