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
public class ServletRegistrar extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        
        String nombre = request.getParameter("textb_Nombre");
        String apellidos = request.getParameter("text_Apellidos");
        String correo = request.getParameter("textb_Correo");
        String contrasena = request.getParameter("textb_Contrasena");
        String fechaNacimiento = request.getParameter("textb_Fech_nacimiento");
        
        Usuario usu = new Usuario();
        Perfil perfil = usu.Registro(nombre, apellidos, correo, contrasena, fechaNacimiento);
        
        if(perfil.getMensaje().equals("YES"))
        {
            request.getSession().setAttribute("Usuario", perfil.getUsuario());
            request.getRequestDispatcher("ingHabilidades.jsp").forward(request, response);
        }
        else
        {
            request.getSession().setAttribute("MensajeError", perfil.getMensaje());
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletRegistrar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
