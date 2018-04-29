<%-- 
    Document   : crear
    Created on : 28-abr-2018, 22:11:34
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A&ntilde;adir</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3>Los datos introducidos son: </h3>
        
        <form action="insertar" method="post">
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
    </body>
</html>
