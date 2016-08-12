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
//    INSERT INTO habilidades (hab_matematica, hab_fisica, hab_quimica, hab_programacion, 
//            hab_biologia, hab_estadistica, hab_español,
//            hab_calificacion, usu_correo) VALUES ('1', '1', '1', '1', '1', '1', '1', '1', 'julian@julian.com');
//    
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
            System.out.println(e.getMessage());
            System.out.println(("INSERT INTO habilidades (hab_matematica, hab_fisica, "
                    + "hab_quimica, hab_programacion," +
                "hab_biologia, hab_estadistica, hab_español," +
                "hab_calificacion, usu_correo) VALUES ('"+hab.getHab_matematicas()+"','"+hab.getHab_fisica()+
                        "','"+hab.getHab_quimica()+"','"+hab.getHab_programacion()+"','"+
                    hab.getHab_biologia()+"','"+hab.getHab_estadistica()+"','"+hab.getHab_espanol()+
                    "','-1','"+hab.getUsu_correo()+"')"));
        }
    }
}
