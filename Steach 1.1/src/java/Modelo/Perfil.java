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
    private Usuario amigo;
    private Habilidad habilidad_Amigo;
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

    public Usuario getAmigo() {
        return amigo;
    }

    public void setAmigo(Usuario amigo) {
        this.amigo = amigo;
    }

    public Habilidad getHabilidad_Amigo() {
        return habilidad_Amigo;
    }

    public void setHabilidad_Amigo(Habilidad habilidad_Amigo) {
        this.habilidad_Amigo = habilidad_Amigo;
    }

    public String getListaHab() {
        return listaHab;
    }

    public void setListaHab(String listaHab) {
        this.listaHab = listaHab;
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
    
        public String ListaHabsAmigo (){
         String habilidades_usu="";
         if(this.getHabilidad_Amigo().getHab_biologia().equals("1")){
                habilidades_usu=habilidades_usu + "Biologia   ";
            }
            if(this.getHabilidad_Amigo().getHab_espanol().equals("1")){
                habilidades_usu = habilidades_usu + "Espanol   ";
            }
            if(this.getHabilidad_Amigo().getHab_estadistica().equals("1")){
                habilidades_usu = habilidades_usu + "Estadistica   ";
            }
            if(this.getHabilidad_Amigo().getHab_fisica().equals("1")){
                habilidades_usu = habilidades_usu + "Fisica   ";
            }
            if(this.getHabilidad_Amigo().getHab_matematicas().equals("1")){
                habilidades_usu = habilidades_usu + "Matematicas   ";
            }
            if(this.getHabilidad_Amigo().getHab_programacion().equals("1")){
                habilidades_usu = habilidades_usu + "Programacion   ";
            }
            if(this.getHabilidad_Amigo().getHab_quimica().equals("1")){
                habilidades_usu = habilidades_usu + "Quimica   ";
            }
         return habilidades_usu;
    }

    
    public ArrayList<String> ConsultarNombres (String nombre) throws SQLException{
        UsuarioDAO UsuDAO = new UsuarioDAO();
        return UsuDAO.ConsultarNombre(nombre);
    }
    
    /*
    public Perfil verificarAmigo(){
        UsuarioDAO UsuDAO = new UsuarioDAO();
        boolean SonAmigos = UsuDAO.SonAmigos(mensaje, mensaje)
        if(!SonAmigos) return false;
        else return true;
    }*/
    
        public Perfil iniciarPerfilTercero(String correoTercero){
        UsuarioDAO usuTerceroDAO = new UsuarioDAO();
        Perfil perfil=new Perfil();
        Usuario usuTercero=new Usuario();
        try {
            usuTercero=usuTerceroDAO.verificarUsuario(correoTercero);
            perfil.setAmigo(usuTercero);
            
        } catch (SQLException e) {
            perfil.setMensaje(e.getMessage());
        }
        Habilidad habTercero = new Habilidad();
        HabilidadDAO habTerceroDAO = new HabilidadDAO();
        habTercero=habTerceroDAO.ObtenerHabilidad(correoTercero);
        perfil.setHabilidad_Amigo(habTercero);
        if(usuTercero.getUsu_veces_suspendido() >=3){
            perfil.setMensaje("La cuenta con el correo "+correoTercero+" ha sido suspendida de manera permanente, por lo tanto no podra acceder a la aplicación");
        }
        return perfil;
    }
}
