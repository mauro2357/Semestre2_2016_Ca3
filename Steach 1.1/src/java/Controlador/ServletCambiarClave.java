/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Perfil;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SONY
 */
public class ServletCambiarClave extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //El concepto GET es obtener información del servidor.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    //POST sin embargo es enviar información desde el cliente para que sea procesada y actualice o agregue información en el servidor
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario Usu = new Usuario();
        String Correo = (String)request.getParameter("textb_correo");
        String ClaveActual = (String)request.getParameter("textb_claveActual");
        String ClaveNueva1 = (String)request.getParameter("textb_claveNueva1");
        String ClaveNueva2 = (String)request.getParameter("textb_claveNueva2");
        Boolean ClaveValidada = Usu.CambiarClave(Correo,ClaveActual,ClaveNueva1,ClaveNueva2);
        if(!ClaveValidada){
            request.getSession().setAttribute("Error", "Hubo un error al intentar cambiar la clave");
            request.getRequestDispatcher("Vista_cambiarClave.jsp").forward(request, response);
            return;
        }
        else
        {
            Perfil perfil = Usu.iniciarSesion(Correo);
            request.getSession().setAttribute("Usuario_propio", perfil.getUsuario());
            request.getSession().setAttribute("hab", perfil.getHabilidad());
                
            String habilidades_usu="";
                if(perfil.getHabilidad().getHab_biologia().equals("1")){
                    habilidades_usu=habilidades_usu + "Biologia   ";
                }
                if(perfil.getHabilidad().getHab_espanol().equals("1")){
                    habilidades_usu = habilidades_usu + "Espanol   ";
                }
                if(perfil.getHabilidad().getHab_estadistica().equals("1")){
                    habilidades_usu = habilidades_usu + "Estadistica   ";
                }
                if(perfil.getHabilidad().getHab_fisica().equals("1")){
                    habilidades_usu = habilidades_usu + "Fisica   ";
                }
                if(perfil.getHabilidad().getHab_matematicas().equals("1")){
                    habilidades_usu = habilidades_usu + "Matematicas   ";
                }
                if(perfil.getHabilidad().getHab_programacion().equals("1")){
                    habilidades_usu = habilidades_usu + "Programacion   ";
                }
                if(perfil.getHabilidad().getHab_quimica().equals("1")){
                    habilidades_usu = habilidades_usu + "Quimica   ";
                }
                request.getSession().setAttribute("Habilidades_usu", habilidades_usu);
                request.getRequestDispatcher("Perfil.jsp").forward(request, response);   
        }
    }
}
