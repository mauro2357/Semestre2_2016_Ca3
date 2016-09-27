<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Steach</title>
        <link href="CSS/Vista_InicioStyle.css" type="text/css" rel="stylesheet" >
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
                    <li><input type="submit" id="boton_buscar" name="btn_buscar" value="Buscar" onclick=this.form.action="ServletIniciarSesion" ></a>
                    </input>
            </ul>
        </div>
    </div>
    <div id="contenedorRegistro">
        <h1> Registrate </h1>
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
