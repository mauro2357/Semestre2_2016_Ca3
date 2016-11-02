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
public class ServletPerfilTercero extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");        
        Perfil perfil = new Perfil();
        
        String correotercero=request.getParameter("correotercero");
        perfil= perfil.iniciarPerfilTercero(correotercero);
        perfil.setUsuario( (Usuario) request.getSession().getAttribute("Usuario_propio") );
        //perfil.iniciarPerfilTercero(correotercero);
        PerfilDAO perfilDAO = new PerfilDAO();
        UsuarioDAO usuDAO= new UsuarioDAO();
        perfil.getAmigo().setiUsuarioDAO(usuDAO);
        
        boolean SonAmigos = perfilDAO.SonAmigos(perfil.getUsuario().getUsu_correo(), perfil.getAmigo().getUsu_correo());
        if(perfil.getUsuario().getUsu_correo().equals(perfil.getAmigo().getUsu_correo())){
            perfil.setTipodeusuario("PerfilPropio");
            perfil.setHabilidad(perfil.getHabilidad_Amigo());
        }
        else if(SonAmigos){
            perfil.setTipodeusuario("PerfilAmigo");
        }
        else{
            perfil.setTipodeusuario("PerfilTercero");
        }

        perfil.setMatrizScripPublicaciones(perfil.getAmigo().MatPublicacionesJScrip(perfil.getAmigo().getUsu_correo() ));


        request.getSession().setAttribute("Perfil", perfil);
        request.getSession().setAttribute("Usuario_amigo", perfil.getAmigo());
        request.getSession().setAttribute("Usuario_propio", perfil.getUsuario());
        request.getSession().setAttribute("hab", perfil.getHabilidad_Amigo());
        request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabsAmigo());
        request.getRequestDispatcher("Perfil.jsp").forward(request, response);  

        
        
        
        /*
        request.getSession().setAttribute("Usuario", perfil.getAmigo());
        request.getSession().setAttribute("hab", perfil.getHabilidad_Amigo());
        request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabsAmigo());
        request.getRequestDispatcher("Perfil.jsp").forward(request, response);
        */
        /*
        boolean SonAmigos = perfilDAO.SonAmigos(perfil.getUsuario().getUsu_correo(), correotercero);
        if(!SonAmigos) request.getSession().setAttribute("MensajeError", perfil.getUsuario().getUsu_nombre());
        else request.getSession().setAttribute("MensajeError", "Si Dio");
        request.getSession().setAttribute("Amigo", correotercero);
        */
        
        
        
        
        //
        /*
        String error = (String)request.getSession().getAttribute("MensajeError");
        Usuario usu= (Usuario)request.getSession().getAttribute("Usuario");
        Habilidad hab= (Habilidad)request.getSession().getAttribute("hab");
        String habilidades_usu = (String)request.getSession().getAttribute("Habilidades_usu");
        String Amigo = (String)request.getSession().getAttribute("Amigo");
        */
        /*
        request.setAttribute("MensajeError", "nulll");
        request.getSession().setAttribute("Usuario", perfil.getAmigo());
        request.getSession().setAttribute("hab", perfil.getHabilidad_Amigo());
        request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabsAmigo());
        request.getSession().setAttribute("Amigo", perfil.getAmigo().getUsu_correo());
        request.getRequestDispatcher("PerfilVisita.jsp").forward(request, response);
        */
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
