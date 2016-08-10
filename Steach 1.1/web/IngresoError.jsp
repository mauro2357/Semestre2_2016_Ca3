<%-- 
    Document   : IngresoError
    Created on : 3/08/2016, 12:42:21 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg=(String)request.getSession().getAttribute("MnsajeError");
%>
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
    /*Margen de ancho*/
    margin:20px;
    border-radius:10px;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:right;
  }
  
#boton_inicio{
    background:#080808;
    color: #f2f2f2;
    padding: 10px;
    font-size: 16px;
    border-radius: 5px;
    position: relative;
    box-sizing: border-box;
    transition: all 500ms ease;
    text-decoration:none;
    margin:20px;
}

 #boton_inicio:hover{
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
      <li><a href="Index.jsp">Inicio</a></li>
    </ul>
    </div>
  </div>
  <div id="contenedor">
    <h1>Ups!</h1>
    <p><strong><%=msg%></strong> vuelve a la pagina principal y ingresa los datos correctamente. </p>
    <br> <br>
    <a id="boton_inicio" href="Index.jsp"> Volver</a>
     <br>  <br>
  </div> 
</body>
</html>
