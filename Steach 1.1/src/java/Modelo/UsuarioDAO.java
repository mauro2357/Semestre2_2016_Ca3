
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
//Esta es la clase donde estan todos los metodos de cliente, los metos deben ser llamados desde el controlador

public class UsuarioDAO {
    Conexion conex;
    
    public UsuarioDAO(){
        conex= new Conexion();
    }
    
    public Usuario verificarUsuario(String usu_correo){
        Usuario usu= new Usuario();
        try {
            Statement estatuto2 = conex.getConnection().createStatement();
            ResultSet rs = estatuto2.executeQuery("select * from db_steach.usuario where usu_correo='"+usu_correo+"';");
            usu.setUsu_correo(usu_correo);
            rs.next();
            //JOptionPane.showMessageDialog(null, "Dentro de Comprobar cliente "+rs.next());
            String usu_nombre = rs.getString("usu_nombre");
            String usu_ape = rs.getString("usu_apellidos");
            String usu_contra = rs.getString("usu_contra");
            String usu_fechNacimiento = rs.getString("usu_fechNacimiento");

            usu.setUsu_nombre(usu_nombre);
            usu.setUsu_apellidos(usu_ape);
            usu.setUsu_contra(usu_contra);
            usu.setUsu_fecha_nacimiento(usu_fechNacimiento);
            
            estatuto2.close();
            conex.desconectar();
        } 
        catch (Exception e) {
            
        }
        return usu;
    }
    
    public void registrarUsuario(Usuario usu) throws SQLException
    {
        Statement estatuto = conex.getConnection().createStatement();
        try {
            
            estatuto.executeUpdate("INSERT INTO db_steach.usuario VALUES ('"+usu.getUsu_correo()+"', '"
                            +usu.getUsu_nombre()+"', '"+usu.getUsu_apellidos()
                            +"', '"+usu.getUsu_contra()+"', '"+usu.getUsu_fecha_nacimiento()+"')");
        } catch (SQLException e) {
            throw new SQLException("El usuario registrado con "+usu.getUsu_correo()+" ya se encuentra registrado");
        }
        estatuto.close();
        conex.desconectar();
    }   
    
}
