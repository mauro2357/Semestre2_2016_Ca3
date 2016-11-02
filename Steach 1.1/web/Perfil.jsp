<%@page import="Modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Perfil perfil = (Perfil)request.getSession().getAttribute("Perfil");
    Usuario usu= (Usuario)request.getSession().getAttribute("Usuario_amigo");
    Habilidad hab= (Habilidad)request.getSession().getAttribute("hab");
    String habilidades_usu = (String)request.getSession().getAttribute("Habilidades_usu");
    String calif = hab.Suspender();
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
    <div id="calificacion">
        <div id="foto-perfil">
            <br><br><br>
            <h2>Foto</h2> 
        </div>
        <h2 align="left"><%=usu.getUsu_nombre()%> <%=usu.getUsu_apellidos()%></h2>
    </div>
    <form action="" method="post">
    <script>
        var tipousu = "<%=perfil.getTipodeusuario()%>";
        if(tipousu != "PerfilPropio"){     
            if(tipousu == "PerfilAmigo"){
                document.write(
                '<div id="botones_superiores">'+
                '<input type="submit" id="boton_noseguir" value="Dejar de seguir" onclick=this.form.action="ServletDejardeSeguir" >'+
                "</div>"
                );
            }
            else{
                document.write(
                '<div id="botones_superiores">'+
                '<input type="submit" id="boton_steach" value="Seguir" onclick=this.form.action="ServletSeguir" >'+
                "</div>"
                );
        
            }
        }    
    </script>
    
    <div id="habilidades">
        <h3>Habilidaes que me gusta enseñar</h3>
        <h4> <%=habilidades_usu %> </h4>
        <br>
        <h3>Calificación</h3>
        <h4> <%=calif %> </h4>        
        <script>
            if(tipousu == "PerfilAmigo"){
                document.write('<input type="submit" id="boton_steach" value="Calificar" onclick=this.form.action="VistaCalificar.jsp" >');  
            }
        </script>
    </div>  
    
    <script>
        var tipousu = "<%=perfil.getTipodeusuario()%>";
        if(tipousu != "PerfilTercero"){
            document.write(
            '<div id="div_publicacion">'+        
                '<input type="text" id="Text_publicacion" name="Text_publicacion">'+
                '<input type="submit" id="boton_steach" value="Publicar" onclick=this.form.action="ServletPublica" >'+
            '</div>'
            );
        }
    </script>
    </form>

    <script>     
        var Matrizpub = <%=perfil.getMatrizScripPublicaciones()%>;
        for(var i=0; i<Matrizpub.length; i++){
                document.write('<div id="div_publicacion">'+Matrizpub[i][1]+' ha publicado a '+Matrizpub[i][0]+' <br> '+Matrizpub[i][2]+'</div>');
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