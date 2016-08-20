/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SONY
 */
public class Perfil {
    private Usuario usuario;
    private Habilidad habilidad;
    private String mensaje;
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
    
    
    
}
