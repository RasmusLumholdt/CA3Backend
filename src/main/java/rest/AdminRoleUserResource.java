/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author wicktus
 */
@Path("AdminRoleUser")
@RolesAllowed("admin")
public class AdminRoleUserResource {

    @Context
    private UriInfo context;

    private ExecutorService pool;

    /**
     * Creates a new instance of AdminRoleUserResource
     */
    public AdminRoleUserResource() {
        this.pool = Executors.newCachedThreadPool();
    }

    /**
     * Retrieves representation of an instance of rest.AdminRoleUserResource
     *
     * @return a response containing the appropriate JSON
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        //TODO return proper representation object
        return (Response) pool.submit(new ResourceRequest(""));
    }

    /**
     * PUT method for updating or creating an instance of AdminRoleUserResource
     *
     * @param content representation for the resource
     * @return a success response
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        return (Response) pool.submit(new ResourceRequest(content));
    }
}
