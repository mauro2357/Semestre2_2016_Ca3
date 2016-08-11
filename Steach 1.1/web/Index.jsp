<%-- 
    Document   : Index
    Created on : 3/08/2016, 10:48:15 AM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Inicio Steach</title>
    <div class="info-usuario">
        <ul class="navegacion">
    </from>
    </ul>
    </div>
<link href="CSS/Style.css" type="text/css" rel="stylesheet" >

</head>

<body background = "Fondo2.jpg">
  <div id="barra_superior">
    <ul class="navegacion">
      <li><a href="Registro.jsp">¿No tienes Cuenta? Regístrate</a></li>
      <li><a href="QuinesSomos.jsp">Quienes Somos</a></li> 
      <li><a href="PulicacionesPopulares.jsp">Publicaciones Populares</a></li> 
      <li><a href="ProfesoresMejorCalificados.jsp">Profesores Mejor Calificados</a></li>
        <form  action="ServletIniciarSesion" method="post">
            <li><input type="text" id="textb_correoint" name="textb_correoint" placeholder="Correo" required></li>
            <li><input type="text" id="textb_contraint" name="textb_contraint" placeholder="Contra" required></li>
            <li><input type="submit" id="boton_ingresar" value="Ingresar">  </input></li> 
        <form/>
    </ul>
  </div>
    <div id = "imagen"><img src="Ca3.png" width="10%" align="right"></div> 
    
  <div id="InfoGeneral">
    <h1>Steach</h1>
           
    <p><strong>Steach, una aplicacion para el aprendizaje</strong> <br>
        <adress>Steach S.A.S Una Marca de Ca3, Donde tus conocimientos Son lo mas importante.</adress> </p>

  </div>
    <div id = "Videos">
        <center>
            <h3>Mira una Galería de Videos de como Funciona Nuestro Proyecto
            dentro del cual estás a punto de ser parte.
            Te agradecemos por visitarnos, si quieres saber mas sobre nostros ve hacia arriba
            y da en la opcion "Quienes Somos". <br></h3>
            A continuación los videos.
            <h4 align="left">El primero es The Black Eyes Peas, Escúchalo</h4>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/uSD4vsh1zDA" frameborder="0" allowfullscreen></iframe>
            <h4 align="left">El segundo es The Black Eyes Peas pero con pump it, Escúchalo</h4>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/ZaI2IlHwmgQ" frameborder="0" allowfullscreen></iframe>
        </center>
        
    </div>
</body>
</html>