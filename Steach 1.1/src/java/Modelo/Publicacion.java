package Modelo;

public class Publicacion {
    
    public String Pub_codigo;
    public String Pub_amigo_correo;
    public String Pub_usu_correo;
    public String Pub_comentario;

    public Publicacion() {
        this.Pub_codigo = "";
        this.Pub_amigo_correo = "";
        this.Pub_usu_correo = "";
        this.Pub_comentario = "";
    }
    
    public Publicacion(String Pub_codigo, String Pub_amigo_correo, String Pub_usu_correo, String Pub_comentario) {
        this.Pub_codigo = Pub_codigo;
        this.Pub_amigo_correo = Pub_amigo_correo;
        this.Pub_usu_correo = Pub_usu_correo;
        this.Pub_comentario = Pub_comentario;
    }

    public String getPub_codigo() {
        return Pub_codigo;
    }

    public void setPub_codigo(String Pub_codigo) {
        this.Pub_codigo = Pub_codigo;
    }

    public String getPub_amigo_correo() {
        return Pub_amigo_correo;
    }

    public void setPub_amigo_correo(String Pub_amigo_correo) {
        this.Pub_amigo_correo = Pub_amigo_correo;
    }

    public String getPub_usu_correo() {
        return Pub_usu_correo;
    }

    public void setPub_usu_correo(String Pub_usu_correo) {
        this.Pub_usu_correo = Pub_usu_correo;
    }

    public String getPub_comentario() {
        return Pub_comentario;
    }

    public void setPub_comentario(String Pub_comentario) {
        this.Pub_comentario = Pub_comentario;
    }
    
    
    
}

