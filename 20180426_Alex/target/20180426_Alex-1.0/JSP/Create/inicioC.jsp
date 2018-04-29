<%-- 
    Document   : inicioC
    Created on : 28-abr-2018, 18:26:34
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A&ntilde;adir</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3>Introduzca los datos a insertar</h3>
        <p class="error">${error}</p>
        
        <form action="crear" method="post">
            <table>
                <tr>
                    <td><label>Anilla:</label></td>
                    <td><input type="text" name="anilla"/></td>
                </tr>
                <tr>
                    <td><label>Especie:</label></td>
                    <td><input type="text" name="especie"/></td>
                </tr>
                <tr>
                    <td><label>Lugar:</label></td>
                    <td><input type="text" name="lugar"/></td>
                </tr>
                <tr>
                    <td><label>Fecha:</label></td>
                    <td><input type="text" name="fecha"/></td>
                </tr>
                <tr>
                    <td><input type="submit" name="enviar" value="Enviar"/></td>
                    <td><input type="submit" name="volver" value="Volver"/></td>
                </tr>  
            </table>
                   
        </form>
        
    </body>
</html>
