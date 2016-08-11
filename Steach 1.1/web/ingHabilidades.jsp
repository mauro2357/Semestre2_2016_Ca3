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

#contenedor3{
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
 #boton_registrar:hover{
    color:#EFF;
    background: #3a7999;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
  }
    
</style>
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
           <input type="text" id="txtb_correo" name="lbl_correo" value=" <%=usu.getUsu_correo() %> "> <br> <br>
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