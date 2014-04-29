<%-- 
    Document   : editarGenero
    Created on : 29-abr-2014, 9:28:45
    Author     : Equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edici&oacute;n de G&eacute;nero</title>
    </head>
    <body>
        <s:form action="editarGeneroProcess">
            <s:textfield name="codGenero" label="Código" readonly="true"/>
            <s:textfield name="nombreGenero" label="Nombre"/>
            <s:submit value="Editar Género"/>
            <s:submit value="Cancelar"/>
        </s:form>
    </body>
</html>
