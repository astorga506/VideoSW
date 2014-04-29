<%-- 
    Document   : mantenerGeneros
    Created on : 08-abr-2014, 11:12:59
    Author     : Equipo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de G&eacute;neros</title>
        <style>
            .button{
                background: rgb(85,188,142);
                color: #fff;
                padding: 8px 12px;
                display: inline-block;
                text-decoration: none;
                border-bottom: 1px solid #000;
            }
        </style>
    </head>
    <body>
        <h1>Mantenimiento de G&eacute;neros</h1>
        <table>
            <tr>
                <td>C&oacute;digo</td>
                <td>Nombre</td>
                <td colspan="2">Acciones</td>
            </tr>
            <s:iterator value="generos" var="generoActual">
                <tr>
                    <td><s:property value="#generoActual.codGenero"/></td>
                    <td><s:property value="#generoActual.nombreGenero"/></td>
                    <td>
                        <s:url action="editarGenero.action" var="url">
                            <s:param name="codGenero" value="#generoActual.codGenero"/>
                        </s:url>
                        <a href="<s:property value="#url"/>">editar</a>
                    </td>
                    <td>
                        <s:url action="eliminarGenero.action" var="url">
                            <s:param name="codGenero" value="#generoActual.codGenero"/>
                        </s:url>
                        <a class="button" href="<s:property value="#url"/>">eliminar</a>
                    </td>
                </tr>                
            </s:iterator>
        </table>
    </body>
</html>
