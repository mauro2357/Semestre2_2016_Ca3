<%@page import="java.util.ArrayList"%>

<%
    String correos =(String)request.getSession().getAttribute("Correos");   
    int cont=0;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Steach</title>
        <link href="CSS/Vista_BuscadorStyle.css" type="text/css" rel="stylesheet" >
    </head>
<body>
    <div id="barra_superior">
        <ul class="navegacion">
            <li><a href="Index.jsp">Inicio</a></li>
        </ul>
        <div class="info-buscador">
            <ul class="navegacion">
                <form action="" method="post">
                <li><input type="text" id="textb_buscador" name="textb_buscardor" placeholder="Buscar"></li>
                 <li class="dropdown">
                    <a href="#" class="dropbtn">Que quieres Buscar?</a>
                    <div class="dropdown-content">
                        <input type="radio" name="BuscarRadio" value="correo"> Buscar personas por correo
                        <input type="radio" name="BuscarRadio" value="nombre" checked="checked"> Buscar personas por nombre
                        <input type="radio" name="BuscarRadio" value="habilidad"> Buscar personas por habilidad
                    </div>
                </li>
                <li><input type="submit" id="boton_registrar" name="btn_buscar" value="Buscar" onclick=this.form.action="ServletBuscarPersonas" ></a>
                </input>
            </ul>
        </div>
    </div>
    <script>
        var cor = <%=correos%>
        for(var i=0; i<cor.length; i++){
                document.write(
                "<div id=\"contenedorRegistro\">"+
                    '<a href="ServletPerfilTercero?correotercero='+cor[i]+'">'+cor[i]+'</a>'
                    +"<br>"+
                "</div>");
        }	
    </script>
</body>
</html>

