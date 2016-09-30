<%-- 
    Document   : PerfilVisita
    Created on : 27/09/2016, 12:36:47 PM
    Author     : SONY
--%>

<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String error = (String)request.getAttribute("MensajeError");
    Usuario usu= (Usuario)request.getSession().getAttribute("Usuario");
    Habilidad hab= (Habilidad)request.getSession().getAttribute("hab");
    String habilidades_usu = (String)request.getSession().getAttribute("Habilidades_usu");
    String Amigo = (String)request.getSession().getAttribute("Amigo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de <%=usu.getUsu_nombre()%></title>
    </head>
    <body>
        <input type="text" id="txtError" value=<%=error%> />
        <form action="ServletPerfilVisita" method="post">
            <h1><%=usu.getUsu_nombre()%> <%=usu.getUsu_apellidos()%></h1>
            <h3>Habilidades que domina: <%=habilidades_usu%></h3>
            <input type="text" hidden="hidden" name="txtCorreo" value=<%=usu.getUsu_correo()%> />
            <select onchange="alerta()" name="txtCalificacion" title="Selecciona la nota que se merecem <%=usu.getUsu_nombre()%>">
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
            <script>
            function error()
            {
                var hola;
                hola = document.getElementById("txtError");
                var btn = document.getElementById("btnSeguir");
                if(hola.value.toString() === "null")
                {
                    btn.value = "Seguir";
                }
                else
                {
                    btn.value = "Dejar de Seguir";
                }
            }
        </script>
        <form action="ServletSeguir" method="post">
            <input type="text" hidden="hidden" name="txtCorreo" value=<%=usu.getUsu_correo()%> />
            <input type="text" hidden="hidden" name="txtCorreoPrincipal" value=<%=Amigo%> />
            <input type="text" hidden="hidden" name="txtError" value=<%=error%> />
            <input type="submit" id="btnSeguir" value="Seguir" name="btnSeguir" />
            <script>error()</script>
        </form>
        <script>
            function alerta()
            {
                var btn = document.getElementById("btnSeguir");
                if(document.getElementById("txtError").toString() !== null)
                {
                    alert(document.getElementById(document.getElementById("txtError").toString()));
                    btn.value = "DejardeSeguir";
                }
                else
                {
                    alert(document.getElementById(document.getElementById("txtError").toString()));
                }
            }
        </script>
    </body>
</html>
