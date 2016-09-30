<%-- 
    Document   : VistaCalificar
    Created on : 30/09/2016, 11:17:19 AM
    Author     : SONY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletCalificar" method="post">
            <b> ¿Mis explicaciones son claras?
                <select name="select4">
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
                <select name="select3">
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
                <select name="select2">
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
                <select name="select1">
                    <optgroup label="calificame">
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </optgroup>
                </select>
            </b>
            <input type="submit" value="Calificar" name="btnCalificar" />
        </form>
        
    </body>
</html>
