<%-- 
    Document   : actualizar
    Created on : 29-abr-2018, 5:38:25
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
        <c:set scope="session" var="ave" value="${ave}"/>
        <h3>Actualice los datos necesarios</h3>
        
        <c:choose>
            <c:when test="${error != null}">
                <p class="error">${error}</p>  
                
                <br>
                <a href="${pageContext.request.contextPath}">Volver al men&uacute; principal</a>
            </c:when>

            <c:otherwise>
        
                <form action="modificar" method="post">
                    <table>
                    <tr>
                            <td><label>Anilla:</label></td>
                            <td><label>${ave.anilla}</label></td>
                        </tr>
                        <tr>
                            <td><label>Especie:</label></td>
                            <td><input type="text" name="especie" placeholder="${ave.especie}"/></td>
                        </tr>
                        <tr>
                            <td><label>Lugar:</label></td>
                            <td><input type="text" name="lugar" placeholder="${ave.lugar}"/></td>
                        </tr>
                        <tr>
                            <td><label>Fecha:</label></td>
                            <td><input type="text" name="fecha" placeholder="${ave.fecha}"/></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="confirmar" value="Confirmar"/></td>
                            <td><input type="submit" name="volver" value="Volver"/></td>
                        </tr>  
                    </table>
                   
                </form>
            </c:otherwise>
        </c:choose>
    </body>
</html>
