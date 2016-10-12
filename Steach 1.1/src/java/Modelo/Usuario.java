
package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class Usuario{
    String usu_nombre;
    String usu_apellidos;
    String usu_fecha_nacimiento;
    String usu_correo;
    String usu_contra;  
    int usu_veces_suspendido;
    int usu_activo;
    String usu_fecha_clave;
    ArrayList<Publicacion> publicaciones;
    IUsuarioDAO iUsuarioDAO;

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
        publicaciones = new ArrayList<>(); //no se si debe de llevar <String> revisar.
    }

    public IUsuarioDAO getiUsuarioDAO() {
        return iUsuarioDAO;
    }

    public void setiUsuarioDAO(IUsuarioDAO iUsuarioDAO) {
        this.iUsuarioDAO = iUsuarioDAO;
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

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
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
    
    public ArrayList<ArrayList<String>> convertirPublicaciones( ArrayList<Publicacion> ListaPublicaciones ){
        ArrayList<ArrayList<String>> MatrizPublicaciones= new ArrayList<>();
        for(int i =0; i<ListaPublicaciones.size(); i++){
           ArrayList<String> listp = new ArrayList<>();
           listp.add(ListaPublicaciones.get(i).getPub_amigo_correo());
           listp.add(ListaPublicaciones.get(i).getPub_usu_correo());
           listp.add(ListaPublicaciones.get(i).getPub_comentario());
           MatrizPublicaciones.add(listp);
        }
        return MatrizPublicaciones;
    }
    
    public String convertirPublicacionesAJavaScrip( ArrayList<Publicacion> ListaPublicaciones ){
        String MatrizScrip="[";
        for(int i =0; i<ListaPublicaciones.size(); i++){           
           MatrizScrip=MatrizScrip+"[\""+ListaPublicaciones.get(i).getPub_amigo_correo()+"\", ";
           MatrizScrip=MatrizScrip+"\""+ListaPublicaciones.get(i).getPub_usu_correo()+"\", ";
           MatrizScrip=MatrizScrip+"\""+ListaPublicaciones.get(i).getPub_comentario()+"\"],";           
        }
        MatrizScrip=MatrizScrip+"]";
        return MatrizScrip;
    }
    
    public String MatPublicacionesJScrip(String correo_a){
        ArrayList<Publicacion> ListPubl = new ArrayList<>();
        try {
            ListPubl=iUsuarioDAO.getPublicacionesPerfilBD(correo_a);
        } catch (Exception e) {
            return "[[\"null\", \"null\", \"no se han podido encontrar publicaciones\"]]";
        }                        
        return convertirPublicacionesAJavaScrip(ListPubl);
    }
    
    public Perfil iniciarSesion(String correo){
        Perfil perfil=new Perfil();
        Usuario usu=new Usuario();
        try {
            usu=iUsuarioDAO.verificarUsuario(correo);
            perfil.setUsuario(usu);
        } catch (SQLException e) {
            perfil.setMensaje(e.getMessage());
        }
        
        ArrayList<Publicacion> ListPublicaciones = new ArrayList<>();
        try {
            ListPublicaciones=iUsuarioDAO.getPublicacionesPerfilBD(correo);
            usu.setPublicaciones(ListPublicaciones);
        } catch (SQLException e) {
            perfil.setMensaje(e.getMessage());
        }
        perfil.setMatrizScripPublicaciones(convertirPublicacionesAJavaScrip(ListPublicaciones));

        Habilidad hab = new Habilidad();
        HabilidadDAO habDAO = new HabilidadDAO();
        hab=habDAO.ObtenerHabilidad(correo);
        perfil.setHabilidad(hab);
        if(usu.getUsu_veces_suspendido() >=3){
            perfil.setMensaje("La cuenta con el correo "+correo+" ha sido suspendida de manera permanente, por lo tanto no podra acceder a la aplicación");
        }
        if(0==usu.getUsu_activo()){
            perfil.setMensaje("La cuenta con el correo "+correo+" ha sido suspendida temporalmente, intente ingresar más tarde");
        }
        if(usu.ValidarMeses(usu.getUsu_correo())){   
            perfil.setCambioContrasenaNecesario(true);
        }
        return perfil;
    }

    public String ObtenerClave(String Correo)
    {
        UsuarioDAO Usu = new UsuarioDAO();
        return Usu.ObtenerClaveDAO(Correo);
    }

    public Boolean CambiarClave(String Correo, String ClaveActual, String ClaveNueva1, String ClaveNueva2) {
        String ClaveDB = this.ObtenerClave(Correo);
        if(!ClaveActual.equals(ClaveDB) || !ClaveNueva1.equals(ClaveNueva2) ||
                ClaveNueva1.equals(ClaveDB) || ClaveNueva2.equals(ClaveDB)) return false;
        UsuarioDAO UsuD = new UsuarioDAO();
        Boolean ans = UsuD.CambiarClave(Correo, ClaveNueva2);
        return ans;
    }
    
    public Perfil Registro (String nombre,String apellidos, String correo, String contrasena, String fechaNacimiento) throws SQLException{
        Perfil perfil = new Perfil();
        Usuario usu = new Usuario();
        UsuarioDAO usuDAO = new UsuarioDAO();
        
        usu.setUsu_nombre(nombre);
        usu.setUsu_apellidos(apellidos);
        usu.setUsu_correo(correo);
        usu.setUsu_contra(contrasena);
        usu.setUsu_fecha_nacimiento(fechaNacimiento);
        usu.setUsu_fecha_clave(fechaNacimiento);
        
        perfil.setMensaje(usuDAO.registrarUsuario(usu));
        if(perfil.getMensaje().equals("YES"))
            perfil.setUsuario(usu);
        return perfil;
    }
    public void accionPublicar(String correo_usuario, String correo_amigo, String publicacion) throws SQLException{
        try {
            iUsuarioDAO.publicar(correo_usuario, correo_amigo, publicacion);
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    
}