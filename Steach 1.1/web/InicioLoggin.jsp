<%-- 
    Document   : InicioLoggin
    Created on : 29/09/2016, 11:43:46 AM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <link href="CSS/InicioLogginStyle.css" type="text/css" rel="stylesheet" >
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

                      <li class="dropdown">
                        <a href="javascript:void(0)" class="dropbtn" onclick="myFunction()">Opciones</a>
                        <div class="dropdown-content" id="myDropdown">
                          <a href="Vista_cambiarClave.jsp">Cambiar clave</a>
                          <a href="Vista_Buscador.jsp">Buscar amigos</a>
                          <a href="#">Cambiar nombre</a>
                        </div>
                      </li>
                    <li></li>
                    <li><a href="#">Salir</a></li>
                </ul>
            </div>
            <div class="nombre-app">
                <ul class="navegacion">
                    <li><w>Steach</w></li>
                </ul>
            </div>
            <div class="foto-perfil">
                <h1>Foto</h1>
            </div>
        </div>
    </body>
</html>