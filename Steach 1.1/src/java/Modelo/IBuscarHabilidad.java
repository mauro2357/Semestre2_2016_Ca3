/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public interface IBuscarHabilidad {
    
    public ArrayList<String> BuscarHab (String nombre) throws SQLException;
    
}
