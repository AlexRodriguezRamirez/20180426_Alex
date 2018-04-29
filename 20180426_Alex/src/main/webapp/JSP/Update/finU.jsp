<%-- 
    Document   : finU
    Created on : 29-abr-2018, 5:50:14
    Author     : Alex
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body class="contenido">
        
        <c:choose>
            <c:when test="${error != null}">
                <p class="error">${error}</p>  
            </c:when>

            <c:otherwise>
                 <h3>Se ha actualizado la anilla ${ave.anilla}.</h3>
            </c:otherwise>
        </c:choose>

        
        <br>
        <a href="${pageContext.request.contextPath}">Volver al men&uacute; principal</a>
    </body>
</html>
