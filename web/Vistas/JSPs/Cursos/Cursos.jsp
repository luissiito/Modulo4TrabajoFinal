
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
        <title>Cursos</title>
    </head>
    <body>
        <h1>Cursos</h1>
        <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
        <a class="Nuevo" href="${pageContext.request.contextPath}/Vistas/JSPs/Cursos/Registrar.jsp">+ NUEVO CURSO</a>
        <main>           
            <c:forEach var="curso" items="${Cursos}">
                <div class="CuadroDeCurso">
                    <form action="${pageContext.request.contextPath}/ControladorCurso" method="post">
                        <input type="hidden" name="operacion" value="eliminar">
                        <input type="hidden" name="id" value="${curso.getId()}">
                        <input type="submit" value="x">
                    </form>
                    <h5>Identificador</h5>
                    <h4>${curso.getId()}</h4>
                    <h5>C&oacute;digo</h5>
                    <h4>${curso.getCodigo()}</h4>
                    <h5>Nombre</h5>
                    <h4>${curso.getNombre()}</h4>
                    <h5>Id Facilitador</h5>
                    <h4>${curso.getIdFacilitador()}</h4>
                    <h5>Last Update</h5>
                    <h4>${curso.getLastUpdate()}</h4>
                </div>
            </c:forEach>
            <input type="hidden" name="nombreDeExcepcionSQL" value="${nombreDeExcepcionSQL}">
            <input type="hidden" name="mensajeDeExcepcionSQL" value="${mensajeDeExcepcionSQL}">
        </main>        
        <script>
            let CuadrosDeCursos = document.querySelectorAll('.CuadroDeCurso');
            let CuadroInformativo = document.createElement('h3');
            for(let c of CuadrosDeCursos){
                c.addEventListener('click', ()=> window.location.href = "${pageContext.request.contextPath}/ControladorCurso?operacion=presentarInformacion&id=" + c.children[2].textContent);
            }
        </script> 
        <script>
            if((${resultadoOperacionInsertar} + 1) == 2){
                CuadroInformativo.innerHTML = (${resultadoOperacionInsertar}) == 1? '<p style="color:green; margin-top:0.5em;">CURSO REGISTRADO EXITOSAMENTE</p>': '<p style="color:red; margin-top:0.5em;">HUBO PROBLEMAS AL REGISTRAR CURSO</p>';
            }
            document.querySelector('main').before(CuadroInformativo);
        </script>  
        <script>
            if((${resultadoOperacionEliminar} + 1) == 2){
                CuadroInformativo.innerHTML = (${resultadoOperacionEliminar}) == 1? '<p style="color:orange; margin-top:0.5em;">CURSO ELIMINADO EXITOSAMENTE</p>': '<p style="color:red; margin-top:0.5em;">HUBO PROBLEMAS AL ELIMINAR CURSO</p>';
            }
            document.querySelector('main').before(CuadroInformativo);
        </script>   
        <script src="${pageContext.request.contextPath}/Scripts/barraLateral.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Scripts/excepcionesCursos.js" type="text/javascript"></script>
    </body>
</html>