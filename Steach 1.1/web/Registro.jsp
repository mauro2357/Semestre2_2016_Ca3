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
  #contenedor{
    /*Ancho*/
    width:600px;
    /*Margen*/
    padding:10px; 
    background:#EFF;
    margin:20px;
    border-radius:10px;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:left;
  }
  
    #contenedorRegistro{
    width:600px;
    padding:10px;
    background:#EFF;
    margin:20px;
    border-radius:10px;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:right;
  }
  
#boton_registrar{
    background:#080808;
    color: #f2f2f2;
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    position: relative;
    box-sizing: border-box;
    transition: all 500ms ease;
    text-decoration:none; 
}

 #boton_registrar:hover{
    color:#EFF;
    background: #3a7999;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
  }
  
  #textb_contraint{
    margin-right: 10px;
    margin-left: 10px;
  }
  
  #boton_ingresar{
      margin-right: 30px;
  }
    
</style>
</head>

<body>
  <div id="barra_superior">
    <ul class="navegacion">
      <li><a href="Index.jsp">Inicio</a></li>
      <li><a href="#">Acerca de nosotros</a></li>
      <li><a href="#">Servicios</a></li>
      <li><a href="ServletIniciarSesion">Contacto</a></li>
    </ul>
    <div class="info-usuario">
    <ul class="navegacion">
      <form action="" method="post">
      <li><input type="text" id="textb_correoint" name="textb_correoint" placeholder="Correo"></li>
      <li><input type="password" id="textb_contraint" name="textb_contraint" placeholder="Contra"></li>
      <li><input type="submit" id="boton_ingresar" name="btn_ingresar" value="Ingresar" onclick=this.form.action="ServletIniciarSesion" ></a>
      </input>
      
    </ul>
    </div>
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
          
          <label>Nombre </label>
          <input type="text" id="textb_Nombre" name="textb_Nombre" placeholder="Nombre">
          <label>Apellidos </label>
          <input type="text" id="textb_Apellidos" name="text_Apellidos" placeholder="Apellidos">
          <br> <br>
          <label>Correo </label>
          <input type="text" id="textb_Correo" name="textb_Correo">
          <br> <br>
          <label>Contra </label>
          <input type="password" id="textb_Contrasena" name="textb_Contrasena">
          <br> <br>
          <label>Fecha de nacimiento </label>
          <input type="date" id="textb_Fech_nacimiento" name="textb_Fech_nacimiento">
          <br> <br> <br>
          <input type="submit" id="boton_registrar" name="btn_registar" value="Registrar"  onclick=this.form.action="ServletRegistrar"></input>
          </form>          
      </h3>     
  </div>
</body>
</html>