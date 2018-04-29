<%-- 
    Document   : finC
    Created on : 29-abr-2018, 3:36:59
    Author     : Alex
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A&ntilde;adir</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        
        <c:choose>
            <c:when test="${error != null}">
                <p class="error">${error}</p>  
            </c:when>

            <c:otherwise>
                 <h3>Se ha añadido la anilla ${ave.anilla}.</h3>
            </c:otherwise>
        </c:choose>

        
        <br>
        <a href="${pageContext.request.contextPath}">Volver al men&uacute; principal</a>
    </body>
</html>
