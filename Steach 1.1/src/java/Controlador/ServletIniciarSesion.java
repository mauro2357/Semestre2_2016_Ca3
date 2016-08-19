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
        
        Usuario usu = new Usuario();
        UsuarioDAO usuDAO = new UsuarioDAO();
        try {
            usu=usuDAO.verificarUsuario(correo);
        } catch (SQLException e) {
            String mensajeError=e.getMessage();
            request.getSession().setAttribute("MensajeError", mensajeError);
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
        }
        Habilidad hab = new Habilidad();
        HabilidadDAO habDAO = new HabilidadDAO();
        hab=habDAO.ObtenerHabilidad(correo);
        
        if(usu.getUsu_veces_suspendido() >=3){
            String mensajeError="La cuenta con el correo "+correo+" ha sido suspendida de manera permanente, por lo tanto no podra acceder a la aplicación";
            request.getSession().setAttribute("MensajeError", mensajeError);
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
        }
        
        if("".equals(usu.getUsu_nombre())){
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
        }
        else{
            if(usu.getUsu_contra().equals(contrasena)){
                request.getSession().setAttribute("Usuario", usu);
                request.getSession().setAttribute("hab", hab);
                
                String habilidades_usu="";
                if(hab.getHab_biologia().equals("1")){
                    habilidades_usu=habilidades_usu + "Biologia   ";
                }
                if(hab.getHab_espanol().equals("1")){
                    habilidades_usu = habilidades_usu + "Espanol   ";
                }
                if(hab.getHab_estadistica().equals("1")){
                    habilidades_usu = habilidades_usu + "Estadistica   ";
                }
                if(hab.getHab_fisica().equals("1")){
                    habilidades_usu = habilidades_usu + "Fisica   ";
                }
                if(hab.getHab_matematicas().equals("1")){
                    habilidades_usu = habilidades_usu + "Matematicas   ";
                }
                if(hab.getHab_programacion().equals("1")){
                    habilidades_usu = habilidades_usu + "Programacion   ";
                }
                if(hab.getHab_quimica().equals("1")){
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

