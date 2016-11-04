<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    //String Correo = request.getSession().getAttribute("Correo");
    String Vector = (String)request.getSession().getAttribute("VectorScript");
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
                <li><a href="ServletPerfilAInicio">Inicio</a></li>
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
    <script>     
        var Matrizpub = <%=Vector%>;
        for(var i=0; i<Matrizpub.length; i++){
                document.write('<div id="div_notificacion">'+Matrizpub[i]+' te publicado <br> </div>');
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