<%-- 
    Document   : mostrarPelicula
    Created on : 27-mar-2014, 15:46:03
    Author     : Equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informaci&oacute;n de la pel&iacute;cula</title>
    </head>
    <body>
        T&iacute;tulo: <s:property value="peliculaSeleccionada.titulo"/><br>
        G&eacute;nero: <s:property value="peliculaSeleccionada.genero.nombreGenero"/><br>
    </body>
</html>
