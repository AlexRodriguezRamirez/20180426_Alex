<%-- 
    Document   : inicioR
    Created on : 28-abr-2018, 18:26:49
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3>Introduzca el anilla que desee consultar</h3>
        <p class="error">${error}</p>
        
        <form action="consultar" method="post">
            <table>
                <tr>
                    <td><label>Anilla:</label></td>
                    <td><input type="text" name="anilla"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="enviar" value="Enviar"/></td>
                    <td><input type="submit" name="volver" value="Volver"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
