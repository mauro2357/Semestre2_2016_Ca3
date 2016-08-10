<%-- 
    Document   : Index
    Created on : 3/08/2016, 12:30:35 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Steach</title>
  
<link href="CSS/Style.css" type="text/css" rel="stylesheet" >

</head>

<body>
  <div id="barra_superior">
    <ul class="navegacion">
      <li><a href="Index.jsp">Inicio</a></li>
      <li><a href="#">Acerca de nosotros</a></li>
      <li><a href="#">Servicios</a></li>
      <li><a href="#">Contacto</a></li>
    </ul>

  </div>
  <div id="contenedor">
    <h1>Steach</h1>
           
<p><strong>Steach, una aplicacion para el aprendizaje</strong> desarrollada por Ca3 equipada con los servicios necesarios para que puedas contactar a personas que te ensenen lo que necesitas. </p>
 
<h2>Historias de usuario</h2>
           
<ul>
   <li>Quiero registrarme.</li>
   <li>dentro del segungo li.</li>
</ul>
 
<blockquote><p>Mirar historias</p></blockquote>
 
  </div>
  <div id="contenedorRegistro">
      <h1>
          Registrate
     </h1>
      <h3>
          <br>
          <form action="ServletRegistrar" method="post">
                <label>Nombre </label>
                <input type="text" id="textb_Nombre" name="textb_Nombre" placeholder="Nombre" required>
                <label>Apellidos </label>
                <input type="text" id="textb_Apellidos" name="text_Apellidos" placeholder="Apellidos" required>
                <br> <br>
                <label>Correo </label>
                <input type="text" id="textb_Correo" name="textb_Correo" required>
                <br> <br>
                <label>Contra </label>
                <input type="text" id="textb_Contrasena" name="textb_Contrasena" required>
                <br> <br>
                <label>Fecha de nacimiento </label>
                <input type="text" id="textb_Fech_nacimiento" name="textb_Fech_nacimiento" required>
                <br> <br> <br>
                <input type="submit" id="boton_registrar" value="Registrar"></input>
          </form>

          
          
      </h3>     
          
      
  </div>
</body>
</html>