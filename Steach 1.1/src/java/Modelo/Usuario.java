
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
    int usu_veces_suspendido;
    int usu_activo;
    String usu_fecha_clave;
    
    
    //Constructor

    public Usuario(String usu_nombre, String usu_apellidos, String usu_fecha_nacimiento, String usu_correo, String usu_contra) {
        this.usu_nombre = usu_nombre;
        this.usu_apellidos = usu_apellidos;
        this.usu_fecha_nacimiento = usu_fecha_nacimiento;
        this.usu_correo = usu_correo;
        this.usu_contra = usu_contra;
    }

    
    public Usuario() {
        usu_nombre = "";
        usu_apellidos = "";
        usu_fecha_nacimiento = "";
        usu_correo = "";
        usu_contra = "";
        
        usu_veces_suspendido = 0;
        usu_activo = 1;
        usu_fecha_clave = "";
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

    
    
    
    
    
    
    public int getUsu_veces_suspendido() {
        return usu_veces_suspendido;
    }

    public void setUsu_veces_suspendido(int usu_veces_suspendido) {
        this.usu_veces_suspendido = usu_veces_suspendido;
    }

    public int getUsu_activo() {
        return usu_activo;
    }

    public void setUsu_activo(int usu_activo) {
        this.usu_activo = usu_activo;
    }

    public String getUsu_fecha_clave() {
        return usu_fecha_clave;
    }

    public void setUsu_fecha_clave(String usu_fecha_clave) {
        this.usu_fecha_clave = usu_fecha_clave;
    }
    
    public boolean ValidarMeses(String Correo)
    {
        UsuarioDAO UsuDao = new UsuarioDAO();
        if(UsuDao.NumMeses(Correo)>=90)
        {
            return true;
        }
        else
        {
            return false;
        }  
    }
}