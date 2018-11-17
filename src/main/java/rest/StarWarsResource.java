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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    @Path("/people/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int id) {
        return (Response) pool.submit(new SwapiResourceRequest("/people/" + id)).get();
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/planet/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlanetById(@PathParam("id") int id) {
        return pool.submit(new SwapiResourceRequest("/planets/" + id));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/people")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPeople() {
        return pool.submit(new SwapiResourceRequest("/people"));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/planet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlanets() {
        return pool.submit(new SwapiResourceRequest("/planets"));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/starships")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStarships() {
        return pool.submit(new SwapiResourceRequest("/starships"));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/starships/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStarshipById(@PathParam("id") int id) {
        return pool.submit(new SwapiResourceRequest("/starships/" + id));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/films")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilms() {
        return pool.submit(new SwapiResourceRequest("/films"));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/films/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFilmsById(@PathParam("id") int id) {
        return pool.submit(new SwapiResourceRequest("/films/" + id));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/species")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllSpecies() {
        return pool.submit(new SwapiResourceRequest("/films"));
    }

    /**
     * Retrieves representation of an instance of rest.StarWarsResource
     *
     * @param id
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/species/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpeciesById(@PathParam("id") int id) {
        return pool.submit(new SwapiResourceRequest("/species/" + id));
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
    @Path("/{type}/{id}/?page={page}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDataByPage(@PathParam("type") String type, @PathParam("id") int id, @PathParam("page") int page) {
        return pool.submit(new SwapiResourceRequest("/" + type + "/" + id + "/?page=" + page));
    }
}
