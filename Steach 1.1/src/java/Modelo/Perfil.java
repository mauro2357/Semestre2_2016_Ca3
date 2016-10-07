package Modelo;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class Perfil {
    
    private Usuario usuario;
    private Habilidad habilidad;
    private Usuario amigo;
    private Habilidad habilidad_Amigo;
    private String mensaje;
    private String listaHab;
    private boolean cambioContrasenaNecesario;
    public String tipodeusuario;
    public ArrayList<ArrayList<String>> MatrizPublicaciones = new ArrayList<>();
    public String MatrizScripPublicaciones;

    public String getMatrizScripPublicaciones() {
        return MatrizScripPublicaciones;
    }

    public void setMatrizScripPublicaciones(String MatrizScripPublicaciones) {
        this.MatrizScripPublicaciones = MatrizScripPublicaciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<ArrayList<String>> getMatrizPublicaciones(){
        return MatrizPublicaciones;
    }

    public void setMatrizPublicaciones(ArrayList<ArrayList<String>> MatrizPublicaciones) {
        this.MatrizPublicaciones = MatrizPublicaciones;
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

    public String getTipodeusuario() {
        return tipodeusuario;
    }

    public void setTipodeusuario(String tipodeusuario) {
        this.tipodeusuario = tipodeusuario;
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

    
    public ArrayList<String> ConsultarNombres (String nombre, String seleccionado) throws SQLException{
        ArrayList<String> ans = new ArrayList<>();
        if(seleccionado.equals("nombre")){
           UsuarioDAO UsuDAO = new UsuarioDAO();
           ans=UsuDAO.ConsultarNombre(nombre); 
        }
        if(seleccionado.equals("correo")){
           UsuarioDAO UsuDAO = new UsuarioDAO();
           ans=UsuDAO.ConsultarCorreo(nombre); 
        }
        if(seleccionado.equals("habilidad")){
            HabilidadDAO habDAO = new HabilidadDAO();
            ans=habDAO.BuscarHab(nombre);
        }
        return ans;
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
