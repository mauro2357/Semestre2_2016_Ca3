/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Habilidad;
import Modelo.HabilidadDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author HP
 */
@Path("Habilidad")
public class HabilidadWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public HabilidadWebService() {
    }

    /**
     * Retrieves representation of an instance of Servicios.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getXml(@QueryParam("correo") String correo) {
        HabilidadDAO HabDAO = new HabilidadDAO();
        Habilidad Hab = HabDAO.ObtenerHabilidad(correo);
        return Hab.getHab_biologia()+"&"+Hab.getHab_espanol()+"&"+Hab.getHab_estadistica()+"&"+Hab.getHab_fisica()
                +"&"+Hab.getHab_matematicas()+"&"+Hab.getHab_programacion()+"&"+Hab.getHab_quimica();
        
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
