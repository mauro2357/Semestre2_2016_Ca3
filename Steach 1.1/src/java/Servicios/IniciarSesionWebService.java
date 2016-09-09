/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Modelo.Perfil;
import Modelo.Usuario;
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
@Path("Inicio")
public class IniciarSesionWebService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of IniciarSesionWebService
     */
    public IniciarSesionWebService() {
    }

    /**
     * Retrieves representation of an instance of Modelo.IniciarSesionWebService
     * @param correo
     * @param contrasena
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getXml(@QueryParam("correo") String correo,@QueryParam("contrasena") String contrasena) {
        Usuario usuario = new Usuario();
        Perfil perfil=usuario.iniciarSesion(correo);
        if(perfil.getMensaje()!=null){
            return perfil.getMensaje();
        }
        
        if(perfil.isCambioContrasenaNecesario()){ 
            return "ContraNecesaria";
        }
        else{
            if(perfil.getUsuario().getUsu_contra().equals(contrasena)){
                String ans = perfil.getUsuario().getUsu_nombre()+"&"+perfil.getUsuario().getUsu_apellidos();
                return ans;
            }
            else{
                return "ContraIncorrecta";
            }
        }
    }

    /**
     * PUT method for updating or creating an instance of IniciarSesionWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
