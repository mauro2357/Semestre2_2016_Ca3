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
<link href="CSS/Style.css" type="text/css" rel="stylesheet" >
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