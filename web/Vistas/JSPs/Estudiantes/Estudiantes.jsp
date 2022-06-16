
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
        <title>Estudiantes</title>
    </head>
    <body>
        <h1>Estudiantes</h1>
        <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>        
        <a class="Nuevo" href="${pageContext.request.contextPath}/Vistas/JSPs/Estudiantes/Registrar.jsp">+ NUEVO ESTUDIANTE</a>
        <main>  
            <c:forEach var="estudiante" items="${Estudiantes}">
                <div class="CuadroDeEstudiante">
                    <form action="${pageContext.request.contextPath}/ControladorEstudiante" method="post">
                        <input type="hidden" name="operacion" value="eliminar">
                        <input type="hidden" name="id" value="${estudiante.getId()}">
                        <input type="submit" value="x">
                    </form>
                    <h5>Identificador</h5>
                    <h4>${estudiante.getId()}</h4>
                    <h5>Rut</h5>
                    <h4>${estudiante.getRut()}</h4>
                    <h5>Nombre</h5>
                    <h4>${estudiante.getNombre()}</h4>
                    <h5>Email</h5>
                    <h4>${estudiante.getEmail()}</h4>
                    <h5>Tel&eacute;fono</h5>
                    <h4>${estudiante.getTelefono()}</h4>
                    <h5>Last Update</h5>
                    <h4>${estudiante.getLastUpdate()}</h4>
                </div>
            </c:forEach>
            <input type="hidden" name="nombreDeExcepcionSQL" value="${nombreDeExcepcionSQL}">
        </main>
        <script>
            let CuadrosDeEstudiantes = document.querySelectorAll('.CuadroDeEstudiante');
            let CuadroInformativo = document.createElement('h3');
            for(let c of CuadrosDeEstudiantes){
                c.addEventListener('click', ()=> window.location.href = "${pageContext.request.contextPath}/ControladorEstudiante?operacion=presentarInformacion&id=" + c.children[2].textContent);
            }
        </script>
        <script>
            if((${resultadoOperacionInsertar} + 1) == 2){
                CuadroInformativo.innerHTML = (${resultadoOperacionInsertar}) == 1? '<p style="color:green; margin-top:0.5em;">ESTUDIANTE REGISTRADO EXITOSAMENTE</p>': '<p style="color:red; margin-top:0.5em;">HUBO PROBLEMAS AL REGISTRAR ESTUDIANTE</p>';
                document.querySelector('main').before(CuadroInformativo);
            }
        </script>  
        <script>
            if((${resultadoOperacionEliminar} + 1) == 2){
                CuadroInformativo.innerHTML = (${resultadoOperacionEliminar}) == 1? '<p style="color:orange; margin-top:0.5em;">ESTUDIANTE ELIMINADO EXITOSAMENTE</p>': '<p style="color:red; margin-top:0.5em;">HUBO PROBLEMAS AL ELIMINAR ESTUDIANTE</p>';
                document.querySelector('main').before(CuadroInformativo);
            }
        </script>    
        <script>
            let nombreDeExcepcionSQL = document.querySelector('input[name="nombreDeExcepcionSQL"]');
            if( nombreDeExcepcionSQL.value == 'SQLIntegrityConstraintViolationException'){
                CuadroInformativo.innerHTML = '<p style="color:red; font-size: 0.8em; margin-top:0.5em;">HAY INFORMACIÓN DEL ESTUDIANTE EN OTRA(s) TABLA(s). NO LO PUEDE ELIMINAR.</p>';
                document.querySelector('main').before(CuadroInformativo);
            }
        </script>    
        <script src="${pageContext.request.contextPath}/Scripts/barraLateral.js" type="text/javascript"></script>
    </body>
</html>