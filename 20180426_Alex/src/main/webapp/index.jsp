<%-- 
    Document   : index
    Created on : 28-abr-2018, 17:41:23
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        
        <h3>Elija la operaci&oacute;n que desee realizar</h3>
        
        <form action="operacion" method="post">
            <input type="radio" name="opcion" value="create" checked="checked"><label>A&ntilde;adir un registro (C)</label><br/>
            <input type="radio" name="opcion" value="read"><label>Consultar un registro (R)</label><br/>
            <input type="radio" name="opcion" value="update"><label>Actualizar un registro (U)</label><br/>
            <input type="radio" name="opcion" value="delete"><label>Eliminar un registro (D)</label><br/><br/>
            
            <input type="submit" name="enviar" value="Enviar"/>
        </form>
        
    </body>
</html>
