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
    
     public boolean SonAmigos(String Correo,String CorreoTercero)
    {
        try {
            Statement st = conex.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM db_steach.amigos where amigo_correo='"+Correo+"' and usu_correo = '"+CorreoTercero+"';");
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
}
