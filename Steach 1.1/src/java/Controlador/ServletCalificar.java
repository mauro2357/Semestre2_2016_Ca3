/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Perfil;
import Modelo.PerfilDAO;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SONY
 */
@WebServlet(name = "ServletCalificar", urlPatterns = {"/ServletCalificar"})
public class ServletCalificar extends HttpServlet {

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
        Perfil perfil = (Perfil)request.getSession().getAttribute("Perfil");
        String correo = perfil.getAmigo().getUsu_correo();
        String select1 = request.getParameter("select1");
        String select2 = request.getParameter("select2");
        String select3 = request.getParameter("select3");
        String select4 = request.getParameter("select4");
        PerfilDAO perfilDAO = new PerfilDAO();
        double calificacion = Double.parseDouble(select1)+ Double.parseDouble(select2)+
                Double.parseDouble(select3)+Double.parseDouble(select4);
        double Promedio = calificacion/4;
        UsuarioDAO UsuDAO = new UsuarioDAO();
        boolean calificar = UsuDAO.Calificar(correo, Promedio);
        if(calificar)
        {
            boolean SonAmigos = perfilDAO.SonAmigos(perfil.getUsuario().getUsu_correo(), perfil.getAmigo().getUsu_correo());
            if(SonAmigos){
                perfil.setTipodeusuario("PerfilAmigo");
            }
            else{
                perfil.setTipodeusuario("PerfilTercero");
            }
            perfil.getHabilidad_Amigo().setHab_calificacion(String.valueOf(Promedio));
            request.getSession().setAttribute("Perfil", perfil);
            request.getSession().setAttribute("Usuario", perfil.getAmigo());
            request.getSession().setAttribute("hab", perfil.getHabilidad_Amigo());
            request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabsAmigo());
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);   
        }
        else
        {
            request.getSession().setAttribute("MensajeError", "No se ha podido calificar a "+perfil.getAmigo().getUsu_correo());
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
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
