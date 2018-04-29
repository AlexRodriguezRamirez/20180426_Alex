<%-- 
    Document   : inicioD
    Created on : 28-abr-2018, 18:26:41
    Author     : Alex
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3>Seleccione los registros que desee eliminar</h3>
        
        <form action="eliminar" method="post">
            <table>
                <tr>
                    <th></th>
                    <th>Anilla</th>
                    <th>Especie</th>
                    <th>Lugar</th>
                    <th>Fecha</th>
                </tr>
                
                <c:forEach var="ave" items="${aves}">
                    <tr>
                        <td><input type="radio" name="eleccion" value="${ave.anilla}"/></td>
                        <td><label>${ave.anilla}</label></td>
                        <td><label>${ave.especie}</label></td>
                        <td><label>${ave.lugar}</label></td>
                        <td><label>${ave.fecha}</label></td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td><input type="submit" name="confirmar" value="Confirmar"/></td>
                        <td><input type="submit" name="volver" value="Volver"/></td>
                    </tr>
                
            </table>
            
        </form>
        
    </body>
</html>