package Modelo;

import static java.lang.Math.abs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class UsuarioDAO implements IUsuarioDAO{
    Conexion conex;
    
    public UsuarioDAO(){
        conex= new Conexion();
    }        
    
    public Usuario verificarUsuario(String usu_correo) throws SQLException{
        Usuario usu= new Usuario();
        usu.setUsu_nombre("");
        try {
            Statement estatuto2 = conex.getConnection().createStatement();
            ResultSet rs = estatuto2.executeQuery("select * from db_steach.usuario where usu_correo='"+usu_correo+"';");
            usu.setUsu_correo(usu_correo);
            rs.next();
            String usu_nombre = rs.getString("usu_nombre");
            String usu_ape = rs.getString("usu_apellidos");
            String usu_contra = rs.getString("usu_contra");
            String usu_fechNacimiento = rs.getString("usu_fechNacimiento");
            String usu_veces_suspendido = rs.getString("usu_veces_suspendido");
            String usu_fecha_clave = rs.getString("usu_fecha_clave");
            String usu_activo = rs.getString("usu_activo");

            usu.setUsu_nombre(usu_nombre);
            usu.setUsu_apellidos(usu_ape);
            usu.setUsu_contra(usu_contra);
            usu.setUsu_fecha_nacimiento(usu_fechNacimiento);
            usu.setUsu_veces_suspendido( Integer.parseInt(usu_veces_suspendido) );
            usu.setUsu_activo(Integer.parseInt(usu_activo) );
            usu.setUsu_fecha_clave(usu_fecha_clave );
            
            estatuto2.close();
            conex.desconectar();
        } 
        catch (SQLException e) {
            throw new SQLException("El usuario con correo "+usu_correo+" no pudo ser encontrado en la base de datos, vuelve a la pagina principal y ingresa los datos correctamente.");
        }
        return usu;
    }
    
    public String registrarUsuario(Usuario usu) throws SQLException
    {
        Statement estatuto = conex.getConnection().createStatement();
        Date fecha = new Date();
        try {
            estatuto.executeUpdate("INSERT INTO `db_steach`.`usuario` (`usu_nombre`, `usu_apellidos`, `usu_correo`, `usu_contra`, `usu_fechNacimiento`,`usu_fecha_clave`,`usu_activo`,`usu_veces_suspendido`) "
                    + "VALUES ('"+usu.getUsu_nombre()+
                    "','"+usu.getUsu_apellidos()+"','"+usu.getUsu_correo()
                            +"','"+usu.getUsu_contra()+"','"+usu.getUsu_fecha_nacimiento()+"',"+"curdate(),'"+1+"','"+0+"')");
        } catch (SQLException e) {
            return "Ocurrio un error al registrar el usuario, intenta de nuevo :3";
        }
        estatuto.close();
        conex.desconectar();
        return "YES";
    }   
    
    public void eliminar_Usuario(String usu_correo) throws SQLException{ 
        Statement estatuto;
        try {
            estatuto =conex.getConnection().createStatement();
            estatuto.executeUpdate("DELETE FROM `db_steach`.`usuario` WHERE `usu_correo`='"+usu_correo+"'");
        } catch (SQLException e) {
            throw new SQLException("El usuario no pudo ser eliminado");
        }
        estatuto.close();
        conex.desconectar();
    }
    
    public int NumMeses(String Correo)
    {
        try {
            Statement st = conex.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select datediff(curdate(),"
                    + "(select usu_fecha_clave from usuario where usu_correo='"+Correo+"'))");
            rs.next();
            int ans = Integer.parseInt(rs.getString(1));
            return abs(ans);
        } catch (Exception e) {
            return -10;
        }
    }

    public String ObtenerClaveDAO(String Correo) {
        try {
            Statement st = conex.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select usu_contra from usuario where usu_correo='"+Correo+"'");
            rs.next();
            return (String)rs.getString(1);
        } catch (Exception e) {
            return "No Hay Contraseña";
        }
    }
    
    public boolean CambiarClave(String Correo,String ClaveNueva)
    {
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("UPDATE `db_steach`.`usuario` SET `usu_fecha_clave`"
                    + "=curdate() WHERE `usu_correo`='"+Correo+"';");
            Statement st2 = conex.getConnection().createStatement();
            st2.executeUpdate("UPDATE `db_steach`.`usuario`"
                    + " SET `usu_contra`='"+ClaveNueva+"' WHERE `usu_correo`='"+Correo+"';");
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public ArrayList<String> ConsultarNombre (String nombre ) throws SQLException{
        ArrayList<String> nombres = new ArrayList<>();
        System.out.println("Nombre: "+nombre);
       
        try {
            Statement estatuto2 = conex.getConnection().createStatement();
            //ResultSet rs = estatuto2.executeQuery("Select usu_correo,usu_nombre like "+nombre+"%"+" from usuario");
            ResultSet rs = estatuto2.executeQuery("SELECT * FROM db_steach.usuario where usu_nombre like '%"+nombre+"%';");
            rs.next();
            while(rs.getRow() != 0){                
                nombres.add(rs.getString("usu_correo"));
                rs.next();
            }             
            estatuto2.close();
            conex.desconectar();
            return nombres;
        } 
        catch (SQLException e) {
            throw new SQLException("No se encontro la persona");
        }        
    }
    
    public ArrayList<String> ConsultarCorreo (String nombre) throws SQLException{
        ArrayList<String> ans = new ArrayList<>();
       
        try {
            Statement estatuto2 = conex.getConnection().createStatement();
            //ResultSet rs = estatuto2.executeQuery("Select usu_correo,usu_nombre like "+nombre+"%"+" from usuario");
            ResultSet rs = estatuto2.executeQuery("SELECT * FROM db_steach.usuario where usu_correo like '%"+nombre+"%';");
            rs.next();
            while(rs.getRow() != 0){                
                ans.add(rs.getString("usu_correo"));
                rs.next();
            }             
            estatuto2.close();
            conex.desconectar();
            return ans;
        } 
        catch (SQLException e) {
            throw new SQLException("No se encontro la persona");
        }        
    }

    public boolean Calificar(String Correo, double Nota){
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("UPDATE `db_steach`.`habilidades`"
                    + " SET `hab_calificacion`='"+Nota+"' WHERE `usu_correo`='"+Correo+"';");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean HacerAmigos(String CorreoPrincipal, String Correo) {
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("INSERT INTO `db_steach`.`amigos` (`amigo_correo`, `usu_correo`) VALUES ('"+Correo+"', '"+CorreoPrincipal+"');");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public ArrayList<Publicacion> getPublicacionesPerfilBD(String usu_correo) throws SQLException{
        ArrayList<Publicacion> ListaPublicaciones = new ArrayList<>();
        //
        Usuario usu= new Usuario();
        try {
            Statement estatuto2 = conex.getConnection().createStatement();
            ResultSet rs = estatuto2.executeQuery("SELECT * FROM db_steach.publicaciones where usu_correo = \""+usu_correo+"\";");
            
            rs.next();
            while(rs.getRow() != 0){  
                Publicacion pub = new Publicacion();
                pub.setPub_codigo( rs.getString("Pub_codigo") );
                pub.setPub_amigo_correo( rs.getString("Pub_amigo_correo") );
                pub.setPub_usu_correo( rs.getString("Pub_usu_correo") );
                pub.setPub_comentario( rs.getString("Pub_comentario"));
                
                ListaPublicaciones.add(pub);
                rs.next();
            }  
                        
            estatuto2.close();
            conex.desconectar();
        } 
        catch (SQLException e) {
            throw new SQLException("No se logro encontrar publicaciones al usuario con correo "+usu_correo);
        }
        return ListaPublicaciones;
    }
}
