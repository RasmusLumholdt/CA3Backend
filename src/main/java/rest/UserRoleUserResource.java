/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * REST Web Service
 *
 * @author wicktus
 */
@Path("roles")
public class UserRoleUserResource {

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    /**
     * Retrieves representation of an instance of rest.UserRoleUserResource
     *
     * @return a response containing the appropriate JSON
     */
    @GET
    @Path("user")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser() {
        String user = securityContext.getUserPrincipal().getName();
        return "\"Hello from USER: " + user + "\"";
    }
    
    @GET
    @Path("admin")
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdmin() {
        String user = securityContext.getUserPrincipal().getName();
        return "\"Hello from USER: " + user + "\"";
    }

}
