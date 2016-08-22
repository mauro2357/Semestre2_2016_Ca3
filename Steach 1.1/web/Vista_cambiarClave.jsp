<%-- 
    Document   : Vista_cambiarClave
    Created on : 17/08/2016, 11:21:00 PM
    Author     : Andres
--%>

<%@page import="Modelo.Habilidad"%>
<%@page import="Modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String Correo= (String)request.getSession().getAttribute("Correo");
    String Error = (String)request.getSession().getAttribute("Error");
    
%>
<html>
    <head>
        <title>Steach</title>
        <link href="CSS/Vista_cambiarClaveStyle.css" type="text/css" rel="stylesheet" >
    </head>
    <body>
        <h2><%=Error%></h2>
        <div id="barra_superior">
            <ul class="navegacion">
                <li><a href="#">Inicio</a></li>
            </ul>
            <div class="info-usuario">
                <ul class="navegacion">
                    <li><a href="#">Perfil</a></li>
                    <li><a href="#">Notificaciones</a></li>
                    <li><a href="#">Salir</a></li>
                </ul>
            </div>
        </div>
        <div id="contenedor">
            <h1>Steach</h1>        
                <p><strong>Para cambiar la clave</strong> solamente debes escribir tu clave anterior y copiar dos veces la clave nueva. </p>
        </div>
        <div id="contenedorRegistro">
            <h1> Registrate </h1>
            <h3>
                <form action="ServletCambiarClave" method="Post">
                    <br>
                    <label>Correo </label>
                    
                    <input type="email" id="textb_correo" name="textb_correo" value= <%=Correo%> >
                    <br> <br>
                    <label>Clave actual </label>
                    <input type="password" id="textb_claveActual" name="textb_claveActual" placeholder="Clave actual">
                    <br> <br>
                    <label>Clave nueva </label>
                    <input type="password" id="textb_claveNueva1" name="textb_claveNueva1" placeholder="Clave nueva">
                    <br> <br>
                    <label>Clave nueva </label>
                    <input type="password" id="textb_claveNueva2" name="textb_claveNueva2"  placeholder="Clave nueva">
                    <br> <br> <br>
                    <input type="submit" value="Cambiar" name="boton_registrar" id="boton_registrar" />
                </form>
            </h3>       
        </div>
    </body>
</html>
