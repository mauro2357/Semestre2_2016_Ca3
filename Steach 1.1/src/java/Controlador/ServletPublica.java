/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Perfil;
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
 * @author Andres
 */
public class ServletPublica extends HttpServlet {

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
        Perfil perfil = new Perfil();
        perfil = (Perfil)request.getSession().getAttribute("Perfil");
        UsuarioDAO usuDAO = new UsuarioDAO();
        perfil.getAmigo().setiUsuarioDAO(usuDAO);
              
        perfil.getUsuario().setiUsuarioDAO(usuDAO);
        String Texto_publicacion = request.getParameter("Text_publicacion");
        
        
        try {
            perfil.getUsuario().accionPublicar(perfil.getUsuario().getUsu_correo(), perfil.getAmigo().getUsu_correo(), Texto_publicacion);
            perfil.setMatrizScripPublicaciones(perfil.getAmigo().MatPublicacionesJScrip(perfil.getAmigo().getUsu_correo() ));
            perfil.setTipodeusuario("PerfilAmigo");
            if(perfil.getUsuario().getUsu_correo().equals(perfil.getAmigo().getUsu_correo())){
                perfil.setTipodeusuario("PerfilPropio");
                perfil.setHabilidad_Amigo(perfil.getHabilidad());
            }
            request.getSession().setAttribute("Perfil", perfil);
            request.getSession().setAttribute("Usuario_amigo", perfil.getAmigo());
            request.getSession().setAttribute("hab", perfil.getHabilidad_Amigo());
            request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabsAmigo());
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);  
            
            /*
            ServletPuertaPerfil serverPuerta = new ServletPuertaPerfil();
            perfil.setTipodeusuario("PerfilAmigo");  
            serverPuerta.doGet(request, response);
            */
            
        } catch (SQLException e) {
            request.getSession().setAttribute("MensajeError", e.getMessage());
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
