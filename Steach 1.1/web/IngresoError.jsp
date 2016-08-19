<%-- 
    Document   : IngresoError
    Created on : 3/08/2016, 12:42:21 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String msg=(String)request.getSession().getAttribute("MensajeError");
%>
<!DOCTYPE html>
<html>
<head>
<title>Steach</title>
<link href="CSS/ErrorStyle.css" type="text/css" rel="stylesheet" >
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
    <p> <%=msg %>, vuelve a la pagina principal y ingresa los datos correctamente. </p>
    <br> <br>
    <a id="boton_inicio" href="Registro.jsp"> Volver</a>
     <br>  <br>
  </div> 
</body>
</html>
