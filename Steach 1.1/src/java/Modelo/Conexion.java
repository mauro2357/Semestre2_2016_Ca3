package Modelo;

import java.sql.*;

public class Conexion {
    public Conexion(){
    }
    
    Connection conex = null;
    Statement stm = null;
    public Connection getConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/db_steach","root","root");
            
        } 
        catch (Exception e) {
        }
        return conex;     
    }
    
    public void desconectar(){
      conex = null;
   }
}


 