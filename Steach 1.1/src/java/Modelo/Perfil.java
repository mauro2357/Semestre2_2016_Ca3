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
 * @author SONY
 */
public class Perfil {
    private Usuario usuario;
    private Habilidad habilidad;
    private String mensaje;
    private String listaHab;
    private boolean cambioContrasenaNecesario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isCambioContrasenaNecesario() {
        return cambioContrasenaNecesario;
    }

    public void setCambioContrasenaNecesario(boolean cambioContrasenaNecesario) {
        this.cambioContrasenaNecesario = cambioContrasenaNecesario;
    }
    
    public String ListaHabs (){
         String habilidades_usu="";
         if(this.getHabilidad().getHab_biologia().equals("1")){
                habilidades_usu=habilidades_usu + "Biologia   ";
            }
            if(this.getHabilidad().getHab_espanol().equals("1")){
                habilidades_usu = habilidades_usu + "Espanol   ";
            }
            if(this.getHabilidad().getHab_estadistica().equals("1")){
                habilidades_usu = habilidades_usu + "Estadistica   ";
            }
            if(this.getHabilidad().getHab_fisica().equals("1")){
                habilidades_usu = habilidades_usu + "Fisica   ";
            }
            if(this.getHabilidad().getHab_matematicas().equals("1")){
                habilidades_usu = habilidades_usu + "Matematicas   ";
            }
            if(this.getHabilidad().getHab_programacion().equals("1")){
                habilidades_usu = habilidades_usu + "Programacion   ";
            }
            if(this.getHabilidad().getHab_quimica().equals("1")){
                habilidades_usu = habilidades_usu + "Quimica   ";
            }
         return habilidades_usu;
    }
    
    public ArrayList<String> ConsultarNombres (String nombre) throws SQLException{
        return new UsuarioDAO().ConsultarNombre(nombre);
    }
}
