
package Controlador;

import Modelo.Perfil;
import Modelo.PerfilDAO;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletAmistad extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAmistad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAmistad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Perfil perfil = new Perfil();
        perfil = (Perfil)request.getSession().getAttribute("Perfil");
        PerfilDAO perfilDAO = new PerfilDAO();
        UsuarioDAO usuDAO= new UsuarioDAO();
        perfil.getAmigo().setiUsuarioDAO(usuDAO);
        perfil.getUsuario().setiUsuarioDAO(usuDAO);
                      
        if(request.getSession()!=null) request.getSession().invalidate();
        perfil.setMatrizScripPublicaciones(perfil.getAmigo().MatPublicacionesJScrip(perfil.getAmigo().getUsu_correo() ));
        if(ejecutarAmistad(perfil) )
        {
            boolean SonAmigos = perfilDAO.SonAmigos(perfil.getUsuario().getUsu_correo(), perfil.getAmigo().getUsu_correo());
            if(SonAmigos){
                perfil.setTipodeusuario("PerfilAmigo");
            }
            else{
                perfil.setTipodeusuario("PerfilTercero");
            }                        
            request.getSession().setAttribute("Perfil", perfil);
            request.getSession().setAttribute("Usuario_amigo", perfil.getAmigo());
            request.getSession().setAttribute("hab", perfil.getHabilidad_Amigo());
            request.getSession().setAttribute("Habilidades_usu", perfil.ListaHabsAmigo());
            request.getRequestDispatcher("Perfil.jsp").forward(request, response);              
        }
        else
        {
            request.getSession().setAttribute("MensajeError", "Imposible ejecutar accion a "+perfil.getAmigo().getUsu_correo());
            request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
        }
    }
    
    protected abstract boolean ejecutarAmistad(Perfil perfil);
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
