<%-- 
    Document   : Index
    Created on : 3/08/2016, 10:48:15 AM
    Author     : Andres
--%>

<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Usuario usu= (Usuario)request.getSession().getAttribute("Usuario");
%>
<!DOCTYPE html>
<html>
<head>
<title>Perfil</title>
<link href="CSS/PerfilStyle.css" type="text/css" rel="stylesheet" >
</head>

<body>
  <div id="barra_superior">
    <ul class="navegacion">
        <li><a href="Index.jsp" id = "imagen"><img src="http://g01.a.alicdn.com/kf/HTB1sQEGHVXXXXXyXpXXq6xXFXXXL/Para-el-caso-de-huawei-ascend-mate-7-3d-minions-cartoon-stitch-sulley-tigger-perro-zebra.jpg_50x50.jpg"></a></li>
    </ul>
    <div class="info-usuario">
    <ul class="navegacion">
        <li><a href="#">Perfil</a></li>
      <li><a href="#">Notificaciones</a></li>
      <li><a href="#">Salir</a></li>
    </ul>
    </div>
    <div class="nombre-app">
    <ul class="navegacion">
        <li><w>Steach</w></li>
    </ul>
    </div>
  </div>
 
  <div id="calificacion">
    <div id="foto-perfil">
        <h1>Foto</h1> 
    </div>
     <h2 align="left"><%=usu.getUsu_nombre()%> <%=usu.getUsu_apellidos()%></h2>
  </div>
  <div id="habilidades">
    <h4>Habilidaes que me gusta enseñar</h4>
  </div>
</html>