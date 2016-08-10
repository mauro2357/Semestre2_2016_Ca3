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
<style>  
  /* reset del body y el html*/
  body,html{margin:0; padding:0;}
  body{font-family:Helvetica, Arial, sans-serif; font-size:14px;}
  
  /* barra superior */
  #barra_superior{
    padding:5px 20px;
    background:#080808;
    font-size:12px;
    color:#FFF;
    -webkit-box-shadow: 0px 0px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 0px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 0px 8px 1px rgba(0 ,0 , 0, 0.3);
    margin-bottom:20px;
    overflow:hidden;
    min-width:920px;
  }
  /*Para que sea de una sola linea*/
  #barra_superior ul{
    list-style:none;
    padding:0; margin:0;  
    float:left;
  }
  /*Para que las opciones esten en un solo renglon*/
  #barra_superior ul li{
    float:left;
    padding:2px; margin:0;
  }
  /*Para que queden como botones las opciones*/
  #barra_superior a{
    display:block;
    height:20px;
    line-height:20px;
    padding:0 5px;
    text-decoration:none;
    color:#FFF;
    border-radius:5px;
  } 
  /*Para que cambie el boton de color cuando pase el mouse*/
  #barra_superior a:hover{
    color:#000;
    background:#EFF;
  }
  /*Para que la info us se haga a la derecha*/
  #barra_superior .info-usuario{
    float:right; 
  }
   
  /* contenedor */
  #InfoGeneral{
    /*Ancho*/
    width:500px;
    /*Margen*/
    padding:10px; 
    background: darkkhaki;
    margin:10px;
    border-radius:10px;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:left;
    font: 100% sans-serif;
  }
  
    #Videos{
    width:450px;
    padding:150px;
    background:burlywood;
    margin:20px;
    border-radius:10px;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 10px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:right;
    text-decoration: none#000000;
  }
  
#imagen
{
    
}
</style>
    <div class="info-usuario">
    <ul class="navegacion">

      </from>
    </ul>
    </div>
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