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
public class regisHabilid extends HttpServlet {

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
        
            String hab_Quimica = (String)request.getParameter("txtb_Quimica");
            String hab_Matematicas = (String)request.getParameter("txtb_Matematicas");
            String hab_Programacion = (String)request.getParameter("txtb_Programacion");
            String hab_Biologia = (String)request.getParameter("txtb_Biologia");
            String hab_Estadistica = (String)request.getParameter("txtb_Estadistica");
            String hab_Espanol = (String)request.getParameter("txtb_Espanol");
            String hab_Fisica = (String)request.getParameter("txtb_fisica");
            String usu_correo = (String)request.getParameter("lbl_correo");
            
            Habilidad hab = new Habilidad();
            hab.setUsuarioDAO(new UsuarioDAO());
            Perfil perfil = hab.CrearHabilidad(usu_correo, hab_Fisica, hab_Espanol, hab_Estadistica, hab_Biologia, hab_Programacion, hab_Matematicas, hab_Quimica);
            
            if(perfil.getMensaje() != null ){
                request.getSession().setAttribute("MensajeError", perfil.getMensaje());
                request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
            }
            perfil.setHabilidad_Amigo(perfil.getHabilidad());
            perfil.setAmigo(perfil.getUsuario());
            perfil.setTipodeusuario("PerfilPropio");  
            request.getSession().setAttribute("Perfil", perfil);
            request.getSession().setAttribute("Usuario",perfil.getUsuario());
            request.getSession().setAttribute("hab", perfil.getHabilidad());
            request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabs());            
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);
            
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
