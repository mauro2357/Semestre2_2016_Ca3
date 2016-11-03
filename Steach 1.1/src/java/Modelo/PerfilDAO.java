package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PerfilDAO {
    Conexion conex;
    
    public PerfilDAO(){
        conex= new Conexion();
    }  
    public void seguirAmigo(){
        
    }
    
     public boolean SonAmigos(String Correousu, String CorreoTerce)
    {
        try {
            Statement st = conex.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM db_steach.amigos where amigo_correo='"+CorreoTerce+"' and usu_correo = '"+Correousu+"';");
            rs.next();
            if(rs.getString(1)==null)
            {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            return false;
        } 
    }
    
    public boolean HacerAmigos(String CorreoPrincipal, String Correo) {
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("INSERT INTO `db_steach`.`amigos` (`amigo_correo`, `usu_correo`) "
                    + "VALUES ('"+Correo+"', '"+CorreoPrincipal+"');");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean EliminarAmigo(String Correousu, String CorreoAmigo){
        try {
            Statement st = conex.getConnection().createStatement();
            st.executeUpdate("DELETE FROM `db_steach`.`amigos` WHERE `amigo_correo`='"+CorreoAmigo+"' and`usu_correo`= '"+Correousu+"';");
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
}
