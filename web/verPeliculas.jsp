<%-- 
    Document   : verPeliculas
    Created on : 27-mar-2014, 13:50:28
    Author     : Equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informaci&oacute;n de Pel&iacute;culas</title>
    </head>
    <body>
        C&oacute;digo: <s:property value="genero.codGenero"/><br>
        Nombre G&eacute;nero: <s:property value="genero.nombreGenero"/><br><br>

        <h1>Cat&aacute;logo de pel&iacute;culas</h1>
        <s:iterator value="peliculas" var="peliculaActual" status="status">
            <s:if test="#status.odd==true">
                <div style="color: #00cc66">
                    T&iacute;tulo: <s:property value="#peliculaActual.titulo"/><br>
                    G&eacute;nero: <s:property value="#peliculaActual.genero.nombreGenero"/><br><br>
                </div>
            </s:if>
            <s:if test="#status.even==true">
                <div style="color: #ff6600">
                    T&iacute;tulo: <s:property value="#peliculaActual.titulo"/><br>
                    G&eacute;nero: <s:property value="#peliculaActual.genero.nombreGenero"/><br><br>
                </div>
            </s:if>
        </s:iterator>  
        <s:form action="mostrarPelicula" method="get">
            <s:select name="codPelicula" list="peliculas" listKey="codPelicula" listValue="titulo" label="Seleccione una película"/>
            <s:submit method="mostrar" value="Enviar"/>
        </s:form>

    </body>
</html>
