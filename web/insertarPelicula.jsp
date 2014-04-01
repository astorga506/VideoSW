<%-- 
    Document   : insertarPelicula
    Created on : 01-abr-2014, 9:37:33
    Author     : Equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserci&oacute;n de pel&iacute;cula</title>
    </head>
    <body>
        <div style="font-family: sans-serif;font-size: larger; font-weight: bold">
            Inserci&oacute;n de pel&iacute;cula   
        </div>
        <s:form action="insertarPeliculaProcess" method="get">
            <s:textfield name="titulo" label="Título de la película"/>
            <s:select name="genero.codGenero" list="generos" listKey="codGenero" listValue="nombreGenero" label="Seleccione un género"/>
            <s:textfield name="totalPeliculas" label="Cantidad de películas"/>
            <s:checkbox name="subtitulada" label="Subtitulada"/>
            <s:checkbox name="estreno" label="Estreno"/>
            <s:submit method="ïnsertar" value="Guardar película"/>
        </s:form>

    </body>
</html>
