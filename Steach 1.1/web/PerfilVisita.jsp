<%-- 
    Document   : PerfilVisita
    Created on : 27/09/2016, 12:36:47 PM
    Author     : SONY
--%>

<%@page import="Modelo.Habilidad"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error = (String)request.getSession().getAttribute("MensajeError");
    Usuario usu= (Usuario)request.getSession().getAttribute("Usuario");
    Habilidad hab= (Habilidad)request.getSession().getAttribute("hab");
    String habilidades_usu = (String)request.getSession().getAttribute("Habilidades_usu");
    String Amigo = "andrea@andrea.com";//(String)request.getSession().getAttribute("Amigo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de <%=usu.getUsu_nombre()%></title>
    </head>
    <body>
        <input type="text" id="txtError" value=<%=error%>  hidden="hidden"/>
        <form action="ServletCalificar" method="post">
            <h1><%=usu.getUsu_nombre()%> <%=usu.getUsu_apellidos()%></h1>
            <h3>Habilidades que domina: <%=habilidades_usu%></h3>
            <input type="text" hidden="hidden" name="txtCorreo" value=<%=usu.getUsu_correo()%> />
            <select onchange="alerta()" name="txtCalificacion" disabled="disabled" title="Selecciona la nota que se merecem <%=usu.getUsu_nombre()%>">
            <option>Aún No</option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            </select>
            <br>
            <br>
        </form>
        <form action="ServletSeguir" method="post">
            <input type="text" hidden="hidden" name="txtCorreo" value=<%=usu.getUsu_correo()%> />
            <input type="text" hidden="hidden" name="txtCorreoPrincipal" value=<%=Amigo%> />
            <input type="submit" id="btnSeguir" value="Seguir" name="btnSeguir" onclick="btn()" />
            <script>alerta()</script>
        </form>
        
        <script>
            function btn()
            {
                var hola;
                hola = document.getElementById("btnSeguir");
                if(hola.value === "Seguir")
                {
                    hola.value = "DejardeSeguir";
                }
                else
                {
                    hola.value = "Seguir";
                }   
            }
        </script>
        <script>
            function alerta()
            {
                if(document.getElementById("txtError") !== null)
                {
                    alert(document.getElementById("txtError"));
                }
            }
        </script>
    </body>
</html>
