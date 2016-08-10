/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class HabilidadDAO {
    Conexion conex;
    
    public HabilidadDAO(){
        conex= new Conexion();
    }
    
    public void registrarHabilidades(Habilidad hab){
        
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO db_steach.habilidades VALUES('"+hab.getHab_matematicas()+"', '"
                            +hab.getHab_fisica()+"', '"+hab.getHab_quimica()
                            +"', '"+hab.getHab_programacion()+"', '"+hab.getHab_biologia()+"', '"+hab.getHab_estadistica()+"', '"+hab.getHab_espanol()+"', '-1', '"+hab.getUsu_correo()+"')");
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("No se puedo registrar las habilidades");
        }
    }
}
