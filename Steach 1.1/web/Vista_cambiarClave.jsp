<%-- 
    Document   : Vista_cambiarClave
    Created on : 17/08/2016, 11:21:00 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Steach</title>
        <link href="CSS/Vista_cambiarClaveStyle.css" type="text/css" rel="stylesheet" >
    </head>
    <body>
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
                <br>
                <label>Correo </label>
                <input type="email" id="textb_correo" name="textb_correo" placeholder="Correo">
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
                <a id="boton_registrar" href="Perfil.jsp"> Registrar</a>       
            </h3>       
        </div>
    </body>
</html>
