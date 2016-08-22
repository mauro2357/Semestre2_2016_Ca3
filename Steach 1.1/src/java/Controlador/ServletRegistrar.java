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
            throws ServletException, IOException {
        
        String nombre = request.getParameter("textb_Nombre");
        String apellidos = request.getParameter("text_Apellidos");
        String correo = request.getParameter("textb_Correo");
        String contrasena = request.getParameter("textb_Contrasena");
        String fechaNacimiento = request.getParameter("textb_Fech_nacimiento");
        
        Usuario usu = new Usuario();
        UsuarioDAO usuDAO = new UsuarioDAO();
        
        usu.setUsu_nombre(nombre);
        usu.setUsu_apellidos(apellidos);
        usu.setUsu_correo(correo);
        usu.setUsu_contra(contrasena);
        usu.setUsu_fecha_nacimiento(fechaNacimiento);
        usu.setUsu_fecha_clave(fechaNacimiento);
        
        try {
            usuDAO.registrarUsuario(usu);
            request.getSession().setAttribute("Usuario", usu);
            request.getRequestDispatcher("ingHabilidades.jsp").forward(request, response);
        } catch (SQLException e) {
            String mensajeError="Ocurrio un error al registrar las habilidades, intenta de nuevo :3";
            request.getSession().setAttribute("MensajeError", mensajeError);
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
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
