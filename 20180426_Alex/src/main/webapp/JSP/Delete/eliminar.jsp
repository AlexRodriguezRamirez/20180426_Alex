<%-- 
    Document   : eliminar
    Created on : 29-abr-2018, 6:16:56
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <c:set scope="session" var="ave" value="${ave}"/>
        <h3>Los siguientes datos ser&aacute;n eliminados</h3>
        
        <c:choose>
            <c:when test="${error != null}">
                <p class="error">${error}</p>  
            </c:when>

            <c:otherwise>
        
                <form action="borrar" method="post">
                    <input type="hidden" name="anilla" value="${ave.anilla}"/>
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
