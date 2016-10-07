/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public interface IUsuarioDAO {
    
    public Usuario verificarUsuario(String usu_correo) throws SQLException;
    public ArrayList<Publicacion> getPublicacionesPerfilBD(String usu_correo) throws SQLException;
    public ArrayList<String> ConsultarNombre (String nombre ) throws SQLException;
    public ArrayList<String> ConsultarCorreo (String nombre) throws SQLException;

    
}
