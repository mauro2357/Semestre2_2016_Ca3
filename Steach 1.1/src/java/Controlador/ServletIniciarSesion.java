
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


public class ServletIniciarSesion extends HttpServlet {

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
                request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabs());
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

