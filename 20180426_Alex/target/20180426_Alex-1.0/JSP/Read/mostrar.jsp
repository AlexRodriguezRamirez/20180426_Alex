<%-- 
    Document   : mostrar
    Created on : 29-abr-2018, 1:13:22
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3>Datos de la anilla introducida</h3>

        <c:choose>
            <c:when test="${error != null}">
                <p class="error">${error}</p>  
            </c:when>

            <c:otherwise>
                <table>
                    <tr>
                        <td><label>Anilla:</label></td>
                        <td><label>${ave.anilla}</label></td>
                    </tr>
                    <tr>
                        <td><label>Especie:</label></td>
                        <td><label>${ave.especie}</label></td>
                    </tr>
                    <tr>
                        <td><label>Lugar:</label></td>
                        <td><label>${ave.lugar}</label></td>
                    </tr>
                    <tr>
                        <td><label>Fecha:</label></td>
                        <td><label>${ave.fecha}</label></td>
                    </tr>
                </table>   
            </c:otherwise>
        </c:choose>

        <br>
        <a href="${pageContext.request.contextPath}">Volver al men&uacute; principal</a>
    </body>
</html>
