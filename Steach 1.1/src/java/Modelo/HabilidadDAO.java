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
    
    public Habilidad ObtenerHabilidad(String usu_correo){
        Habilidad hab= new Habilidad();
        try {
            Statement estatuto2 = conex.getConnection().createStatement();
            ResultSet rs = estatuto2.executeQuery("select * from db_steach.habilidades where usu_correo='"+usu_correo+"';");
            hab.setUsu_correo(usu_correo);
            rs.next();
            String hab_matematica = rs.getString("hab_matematica");
            String hab_fisica= rs.getString("hab_fisica");
            String hab_quimica = rs.getString("hab_quimica");
            String hab_programacion = rs.getString("hab_programacion");
            String hab_biologia = rs.getString("hab_biologia");
            String hab_estadistica = rs.getString("hab_estadistica");
            String hab_español = rs.getString("hab_español");
            String hab_calificacion = rs.getString("hab_calificacion");

            hab.setHab_biologia(hab_biologia);
            hab.setHab_espanol(hab_español);
            hab.setHab_estadistica(hab_estadistica);
            hab.setHab_fisica(hab_fisica);
            hab.setHab_matematicas(hab_matematica);
            hab.setHab_programacion(hab_programacion);
            hab.setHab_quimica(hab_quimica);
            hab.setHab_calificacion(hab_calificacion);
            estatuto2.close();
            conex.desconectar();
        } 
        catch (Exception e) {
            System.out.println("error al verificar en base de datos");
        }
        return hab;
    }
//    INSERT INTO habilidades (hab_matematica, hab_fisica, hab_quimica, hab_programacion, 
//            hab_biologia, hab_estadistica, hab_español,
//            hab_calificacion, usu_correo) VALUES ('1', '1', '1', '1', '1', '1', '1', '1', 'julian@julian.com');
    public void registrarHabilidades(Habilidad hab){
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO habilidades (hab_matematica, hab_fisica, "
                    + "hab_quimica, hab_programacion, \n" +
                "hab_biologia, hab_estadistica, hab_español," +
                "hab_calificacion, usu_correo) VALUES ('"+hab.getHab_matematicas()+"','"+hab.getHab_fisica()+
                        "','"+hab.getHab_quimica()+"','"+hab.getHab_programacion()+"','"+
                    hab.getHab_biologia()+"','"+hab.getHab_estadistica()+"','"+hab.getHab_espanol()+
                    "','-1','"+hab.getUsu_correo()+"')");
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {

        }
    }
}
