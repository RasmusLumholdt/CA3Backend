/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
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
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{type}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataById(@PathParam("type") String type, @PathParam("id") int id) throws InterruptedException, ExecutionException {
        return (Response) pool.submit(new SwapiResourceRequest("/" + type + "/" + id)).get();
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @param type
     * @param id
     * @param page
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData(@PathParam("type") String type, @QueryParam("page") int page) throws InterruptedException, ExecutionException {
        return (Response) pool.submit(new SwapiResourceRequest("/" + type + "/?page=" + (page | 1))).get();
    }
}
