/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Modelo.*;
import java.sql.SQLException;
/**
 *
 * @author Andres
 */
public class Habilidad {
    String usu_correo;
    String hab_fisica;
    String hab_quimica;
    String hab_matematicas;
    String hab_biologia;
    String hab_estadistica;
    String hab_programacion;
    String hab_espanol;
    String hab_calificacion;
    
    public Habilidad(){
    usu_correo="";
    hab_fisica="0";
    hab_quimica="0";
    hab_matematicas="0";
    hab_biologia="0";
    hab_estadistica="0";
    hab_programacion="0";
    hab_espanol="0";
    hab_calificacion="-1";
    }

    public Habilidad(String usu_correo, String hab_fisica, String hab_quimica, String hab_matematicas, String hab_biologia, String hab_estadistica, String hab_programacion, String hab_espanol) {
        this.usu_correo = usu_correo;
        this.hab_fisica = hab_fisica;
        this.hab_quimica = hab_quimica;
        this.hab_matematicas = hab_matematicas;
        this.hab_biologia = hab_biologia;
        this.hab_estadistica = hab_estadistica;
        this.hab_programacion = hab_programacion;
        this.hab_espanol = hab_espanol;
        this.hab_calificacion="-1";
    }

    public String getHab_calificacion() {
        return hab_calificacion;
    }

    public void setHab_calificacion(String hab_calificacion) {
        this.hab_calificacion = hab_calificacion;
    }
    
    

    public String getUsu_correo() {
        return usu_correo;
    }

    public void setUsu_correo(String usu_correo) {
        this.usu_correo = usu_correo;
    }


    public String getHab_fisica() {
        return hab_fisica;
    }

    public void setHab_fisica(String hab_fisica) {
        this.hab_fisica = hab_fisica;
    }

    public String getHab_quimica() {
        return hab_quimica;
    }

    public void setHab_quimica(String hab_quimica) {
        this.hab_quimica = hab_quimica;
    }

    public String getHab_matematicas() {
        return hab_matematicas;
    }

    public void setHab_matematicas(String hab_matematicas) {
        this.hab_matematicas = hab_matematicas;
    }

    public String getHab_biologia() {
        return hab_biologia;
    }

    public void setHab_biologia(String hab_biologia) {
        this.hab_biologia = hab_biologia;
    }

    public String getHab_estadistica() {
        return hab_estadistica;
    }

    public void setHab_estadistica(String hab_estadistica) {
        this.hab_estadistica = hab_estadistica;
    }

    public String getHab_programacion() {
        return hab_programacion;
    }

    public void setHab_programacion(String hab_programacion) {
        this.hab_programacion = hab_programacion;
    }

    public String getHab_espanol() {
        return hab_espanol;
    }

    public void setHab_espanol(String hab_espanol) {
        this.hab_espanol = hab_espanol;
    }
    
    public String Suspender(){
        String calif;
        HabilidadDAO habDAO = new HabilidadDAO();
        if(hab_calificacion.equals("-1")){
            calif = "No ha sido calificado";
            return calif;
        }
        if(Double.parseDouble(hab_calificacion) <= 2){
            habDAO.suspenderDAO(usu_correo);
            calif=hab_calificacion;
            return calif+"\n HA SIDO SUSPENDIDO POR MALO .l. vuelvase serio y enseñe bien";
        }
        else{
            calif=hab_calificacion;
            return calif;
        }
    }
    public Perfil CrearHabilidad(String usu_correo,String hab_Fisica,String hab_Espanol,String hab_Estadistica,String hab_Biologia,String hab_Programacion,String hab_Matematicas,String hab_Quimica){
        Usuario usu = new Usuario();
        Perfil perfil = new Perfil();
        UsuarioDAO usudao= new UsuarioDAO();
        try {
            usu = usudao.verificarUsuario(usu_correo);
            perfil.setUsuario(usu);
        } catch (SQLException e) {
            perfil.setMensaje(e.getMessage());
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
            perfil.setMensaje("No puedes seleccionar mas del 75% de las habilidades");
        }
        Habilidad hab = new Habilidad(usu_correo, hab_Fisica, hab_Quimica, hab_Matematicas, hab_Biologia, hab_Estadistica, hab_Programacion, hab_Espanol);
        HabilidadDAO habDAO = new HabilidadDAO();
        habDAO.registrarHabilidades(hab);
        perfil.setHabilidad(hab);
        return perfil;
    }
}
