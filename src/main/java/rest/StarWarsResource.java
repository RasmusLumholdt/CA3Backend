/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rlumh
 */
@Path("sw")
public class StarWarsResource {

    @Context
    private UriInfo context;
    private ExecutorService pool;

    /**
     * Creates a new instance of StarWarsResource
     */
    public StarWarsResource() {
        this.pool = Executors.newCachedThreadPool();
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return (Response) pool.submit(new ResourceRequest("hej"));
    }

    /**
     * PUT method for updating or creating an instance of StarWarsResource
     *
     * @param content representation for the resource
     * @return a success or failed response
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(String content) {
        return (Response) pool.submit(new ResourceRequest(content));
    }
}
