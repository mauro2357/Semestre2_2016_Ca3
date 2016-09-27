<%-- 
    Document   : Perfil
    Created on : 2/08/2016, 11:25:24 PM
    Author     : Andres
--%>
<%@page import="Modelo.*"%>

<%
    Usuario usu =(Usuario)request.getSession().getAttribute("Usuario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Steach</title>
<link href="CSS/HabilidadesStyle.css" type="text/css" rel="stylesheet" >
</head>
<body>
    <div id="barra_superior">
        <ul class="navegacion">
            <li><a href="#">Inicio</a></li>
        </ul>
    <div class="info-usuario">
        <ul class="navegacion">
            <li><a href="Index.jsp">Salir</a></li>
        </ul>
    </div></div>
    <div id="contenedor">
        <h1>Bienvenido a Steach</h1>
        <p><strong>Steach, una aplicacion para el aprendizaje</strong> desarrollada por Ca3 equipada con los servicios necesarios para que puedas contactar a personas que te ensenen lo que necesitas. </p>
    </div>
    <div id="contenedor">
        <p> Hola  <strong> <%=usu.getUsu_nombre()%> <%=usu.getUsu_apellidos()%> </strong> ingresa tus habilidades, marca en el recuadro un 1 si sabes de este tema y quieres enseñar acerca de él.
        </p>
    </div>
    <div id="contenedor3">
        <form action="regisHabilid" method="post">
            
            <input type="text" id="txtb_correo" name="lbl_correo" value="<%=usu.getUsu_correo()%>"> <br> <br>
            Fisica: <input type="checkbox" id="txtb_fisica" name="txtb_fisica" value="0" placeholder="0"> <br> <br>
            Quimica: <input type="checkbox" id="txtb_Quimica" name="txtb_Quimica" value="0" placeholder="0">  <br> <br>
            Matematicas: <input type="checkbox" id="txtb_Matematicas" name="txtb_Matematicas" value="0" placeholder="0"> <br> <br>
            Programacion: <input type="checkbox" id="txtb_Programacion" name="txtb_Programacion" value="0" placeholder="0"> <br> <br>
            Biologia: <input type="checkbox" id="txtb_Biologia" name="txtb_Biologia" value="0" placeholder="0"> <br> <br>
            Estadistica: <input type="checkbox" id="txtb_Estadistica" name="txtb_Estadistica" value="0" placeholder="0"> <br> <br>
            Espanol: <input type="checkbox" id="txtb_Espanol" name="txtb_Espanol" value="0" placeholder="0"> <br> <br>
           <input type="submit" value="Aceptar" name="btn_habili" />
        </form>
    </div>
</body>
</html>|