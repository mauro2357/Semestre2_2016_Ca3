
package Modelo;

/**
 *
 * @author Andres
 */
public class Usuario {
    String usu_nombre;
    String usu_apellidos;
    String usu_fecha_nacimiento;
    String usu_correo;
    String usu_contra;
    //Constructor

    public Usuario() {
        usu_nombre = "";
        usu_apellidos = "";
        usu_fecha_nacimiento = "";
        usu_correo = "";
        usu_contra = "";
    }

    public String getUsu_nombre() {
        return usu_nombre;
    }

    public String getUsu_apellidos() {
        return usu_apellidos;
    }

    public String getUsu_fecha_nacimiento() {
        return usu_fecha_nacimiento;
    }

    public String getUsu_correo() {
        return usu_correo;
    }

    public String getUsu_contra() {
        return usu_contra;
    }

    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    public void setUsu_apellidos(String usu_apellidos) {
        this.usu_apellidos = usu_apellidos;
    }

    public void setUsu_fecha_nacimiento(String usu_fecha_nacimiento) {
        this.usu_fecha_nacimiento = usu_fecha_nacimiento;
    }

    public void setUsu_correo(String usu_correo) {
        this.usu_correo = usu_correo;
    }

    public void setUsu_contra(String usu_contra) {
        this.usu_contra = usu_contra;
    }

    
    
}