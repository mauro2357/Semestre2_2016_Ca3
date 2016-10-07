/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
/**
 *
 * @author HP
 */
public interface IHabilidadDAO {
    
    public Habilidad ObtenerHabilidad (String usu_correo) throws SQLException;
}
