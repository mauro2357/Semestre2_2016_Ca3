<%-- 
    Document   : Index
    Created on : 3/08/2016, 10:48:15 AM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Perfil</title>
<style>  
  /* reset del body y el html*/
  body,html{margin:0; padding:0;}
  body{font-family:Helvetica, Arial, sans-serif; font-size:14px;background-color: #cccccc;}
  
  /* barra superior */
  #barra_superior{
    padding:5px;
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
    padding:0; margin:auto;  
    float:left;
  }
  /*Para que las opciones esten en un solo renglon*/
  #barra_superior ul li{
    float:left;
    padding:2px; margin:auto;
  }
  /*Para que queden como botones las opciones*/
  #barra_superior a{
    display:block;
    height:50px;
    line-height:50px;
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
   #barra_superior w{
    display:block;
    font-size: 50px;
    height:50px;
    line-height:50px;
    padding:0 0;
    text-decoration:none;
    color:#ff0000;
    border-radius:5px;
  }
  /*Para que la info us se haga a la derecha*/
  #barra_superior .info-usuario{
    float:right; 
  }
  
  #barra_superior .nombre-app{
    float:start;
    overflow: visible;
  }
  #imagen{
      max-width: 50px;
      max-height: 50px;
  }
  /* contenedor */
  #calificacion{
    /*Ancho*/
    min-width:200px;
    /*max-height: 200px;*/
    /*Margen*/
    /*padding:5px 20px;*/ 
    background:#FFF;
    margin:auto;
    border-radius:10px;
    border-color: #cccccc;
    border-style: ridge;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:top;
    overflow: hidden;
  }
  #calificacion b{
    display: table;
  }
  #calificacio h2{
    margin-left: 200px;
    padding: 50px;
  }
  
 
  
  #foto-perfil{
    /*Ancho*/
    width:150px;
    height: 150px;
    /*Margen*/
    /*padding:5px;*/ 
    background:#FFF;
    margin:0;
    padding: 0;
    border-radius:300px;
    border-color: #cccccc;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:left;
  }
  
  #habilidades {
         /*Ancho*/
    width:200px;
    height:200px;
    /*Margen*/
    /*padding:5px;*/ 
    background: #FFF;
    margin:auto;
    border-radius:10px;
    border-color: #cccccc;
    border-style: ridge;
    -webkit-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    -moz-box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    box-shadow: 0px 3px 8px 1px rgba(0 ,0 , 0, 0.3);
    float:left; 
  }

  
    
</style>
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
      <center>
            <div id="foto-perfil">
                <h1>Foto</h1> 
            </div>
         <h2 align="left">Nombre</h2>
            <h1>Calificame</h1>
            <form>
                <b> ¿Mis explicaciones son claras?
                <select>
                    <optgroup label="calificame">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </optgroup>
                </select>
            </b>
            <b> ¿Mis Aportes son valiosos?
                <select>
                    <optgroup label="calificame">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </optgroup>
                </select>
            </b>
            <b> ¿Mis conocimientos son acordes alas habilidades que ofresco?
                <select>
                    <optgroup label="calificame">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </optgroup>
                </select>
            </b>
            <b> ¿Mis Respuestas son rapidas?
                <select>
                    <optgroup label="calificame">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </optgroup>
                </select>
            </b> 
                </form>
      </center>
    
  </div>
  <div id="habilidades">
    <h4>Habilidaes que me gusta enseñar</h4>
  </div>
</html>