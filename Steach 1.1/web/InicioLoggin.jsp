<%-- 
    Document   : InicioLoggin
    Created on : 29/09/2016, 11:43:46 AM
    Author     : HP
--%>

<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Perfil perfil = (Perfil)request.getSession().getAttribute("Perfil");
%>
<!DOCTYPE html>

<html>
<head>
    <title>Inicio</title>
    <link href="CSS/InicioLogginStyle.css" type="text/css" rel="stylesheet" >
</head>
<body>
    <div id="barra_superior">
        <ul class="navegacion">
            <li><a href="Index.jsp" id = "imagen"><img src="http://g01.a.alicdn.com/kf/HTB1sQEGHVXXXXXyXpXXq6xXFXXXL/Para-el-caso-de-huawei-ascend-mate-7-3d-minions-cartoon-stitch-sulley-tigger-perro-zebra.jpg_50x50.jpg"></a></li>
        </ul>
        <div class="info-usuario">
            <div id ="foto-perfil">
                <a href="Perfil.jsp">Nombre</a>
            </div>
            <ul class="navegacion">
                <li><a href="ServletPerfilTercero?correotercero=<%=perfil.getUsuario().getUsu_correo()%>"><%=perfil.getUsuario().getUsu_nombre() + " " + perfil.getUsuario().getUsu_apellidos() %></a></li>
                <li><a href="#">Notificaciones</a></li>
                <li class="dropdown">
                    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction()">Opciones</a>
                    <div class="dropdown-content" id="myDropdown">
                      <a href="Vista_cambiarClave.jsp">Cambiar clave</a>
                      <a href="Vista_Buscador.jsp">Buscar amigos</a>
                      <a href="#">Cambiar nombre</a>
                    </div>
                </li>                    
                <li><a href="#">Salir</a></li>
            </ul>
        </div>
        <div class="nombre-app">
            <ul class="navegacion">
                <li><w>Steach</w></li>
            </ul>
        </div>
    </div>
    <div id ="div_publicacion">
        <input type="text" id="Text_publicacion" name="Text_publicacion">
        <input type="submit" id="boton-pub" value="Publicar" onclick=this.form.action="ServletPublica" >
    </div>
    
    <script>     
        var Matrizpub = <%=perfil.getMatrizScripPublicaciones()%>;
        for(var i=0; i<Matrizpub.length; i++){
                document.write('<div id="conte">'+Matrizpub[i][1]+' ha publicado a '+Matrizpub[i][0]+' <br> '+Matrizpub[i][2]+'</div>');
        }	
    </script>
    
    <script>
        function myFunction() {
            document.getElementById("myDropdown").classList.toggle("show");
        }
        // Close the dropdown if the user clicks outside of it
        window.onclick = function(e) {
          if (!e.target.matches('.dropbtn')) {
            var dropdowns = document.getElementsByClassName("dropdown-content");
            for (var d = 0; d < dropdowns.length; d++) {
              var openDropdown = dropdowns[d];
              if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
              }
            }
          }
        }
    </script>
    

</body>
</html>
