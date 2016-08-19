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
            
            Usuario usu = new Usuario();
            UsuarioDAO usudao= new UsuarioDAO();
            try {
                usu = usudao.verificarUsuario(usu_correo);
            } catch (SQLException e) {
                String mensajeError=e.getMessage();
                request.getSession().setAttribute("MensajeError", mensajeError);
                request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
            }
            int sum_procHab=0;
            if(hab_Quimica == null)
                hab_Quimica="0";
            else{
                hab_Quimica="1";
                sum_procHab+=1;
            }
            if(hab_Matematicas == null) 
                hab_Matematicas="0";
            else{
                hab_Matematicas="1";
                sum_procHab+=1;
            }
            if(hab_Programacion == null)
                hab_Programacion="0";
            else{
                hab_Programacion="1";
                sum_procHab+=1;
            }
            if(hab_Biologia == null) 
                hab_Biologia="0";
            else{
                hab_Biologia="1";
                sum_procHab+=1;
            }
            if(hab_Estadistica == null)
                hab_Estadistica="0";
            else{
                hab_Estadistica="1";
                sum_procHab+=1;
            }
            if(hab_Espanol == null)
                hab_Espanol="0";
            else{
                hab_Espanol="1";
                sum_procHab+=1;
            }
            if(hab_Fisica == null)
                hab_Fisica="0";
            else{
                hab_Fisica="1";
                sum_procHab+=1;
            }
            if(sum_procHab>5){
                String mensajeError="No puedes seleccionar mas del 75% de las habilidades";
                request.getSession().setAttribute("MensajeError", mensajeError);
                request.getRequestDispatcher("IngresoError.jsp").forward(request, response);
            }
            
            
            Habilidad hab = new Habilidad(usu_correo, hab_Fisica, hab_Quimica, hab_Matematicas, hab_Biologia, hab_Estadistica, hab_Programacion, hab_Espanol);
            HabilidadDAO habDAO = new HabilidadDAO();
            habDAO.registrarHabilidades(hab);
            
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
            
            
            request.getSession().setAttribute("Usuario",usu);
            request.getSession().setAttribute("hab", hab);
            request.getSession().setAttribute("Habilidades_usu", habilidades_usu);
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
