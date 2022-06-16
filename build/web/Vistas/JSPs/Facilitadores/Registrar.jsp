
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registrar Facilitador</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/Estilos/main.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>        
        <h1>Registrar Nuevo Facilitador</h1>
         <c:import url="/Vistas/JSPs/CabeceraPrincipal.jsp"></c:import>
         <main class="Presentacion">
             <form action="${pageContext.request.contextPath}/ControladorFacilitador" class="FormularioDeFacilitador" method="post">
                 <label for="rut">Rut</label>
                 <input class="FrmDeRegistro" name="rut" type="text"/>
                 <label for="nombre">Nombre</label>
                 <input name="nombre" type="text"/>
                 <label for="email">Email</label>
                 <input name="email" type="text"/>
                 <label for="telefono">Tel&eacute;fono</label>
                 <input name="telefono" type="text"/>
                 <label for="valorHora">Valor x Hora</label>
                 <input name="valorHora" type="text" placeholder="0.00" required=""/>
                 <label for="banco">Banco</label>
                 <input name="banco" type="text"/>
                 <label for="ctaBancaria">Cuenta Bancaria</label>
                 <input name="ctaBancaria" type="text"/>
                 <label for="lastUpdate">Last Update</label>
                 <input class="FrmDeRegistro" name="lastUpdate" type="text" readonly>
                 <input type="hidden" name="operacion" value="insertar">
                 <input type="submit"  value="Registrar Facilitador">
            </form>
         </main>
         <script src="../../../Scripts/main.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/Scripts/barraLateral.js" type="text/javascript"></script>
    </body>
</html>
