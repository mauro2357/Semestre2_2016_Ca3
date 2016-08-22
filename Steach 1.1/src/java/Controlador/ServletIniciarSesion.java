/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
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
 * @author Andres
 */
public class ServletIniciarSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("textb_correoint");
        String contrasena = request.getParameter("textb_contraint");
        
        Usuario usuario = new Usuario();
        Perfil perfil=usuario.iniciarSesion(correo);
        if(perfil.getMensaje()!=null){
            request.getSession().setAttribute("MensajeError", perfil.getMensaje());
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
            return;
        }
        

        if(perfil.isCambioContrasenaNecesario()){ 
            request.getSession().setAttribute("Correo",correo);
            request.getSession().setAttribute("Error", "Hola "+correo+" nos dimos cuenta que es necesario cambiar"
                    + " clave, sigue los pasos Siguientes");
            request.getRequestDispatcher("Vista_cambiarClave.jsp").forward(request, response);
        }
        else{
            if(perfil.getUsuario().getUsu_contra().equals(contrasena)){
                request.getSession().setAttribute("Usuario", perfil.getUsuario());
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
            else{
                request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
            }
        }
        
       
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

