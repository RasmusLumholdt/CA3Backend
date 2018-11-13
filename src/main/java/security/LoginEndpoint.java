/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.User;
import entity.UserFacade;
import exceptions.AuthenticationException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author rlumh
 */
@Path("login")
public class LoginEndpoint {

    //Set token expire to 30 min.
    public static final int TOKEN_EXPIRE_TIME = 1000 * 60 * 30;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String json) throws AuthenticationException {
        JsonObject jsonString = new JsonParser().parse(json).getAsJsonObject();
        String username = jsonString.get("username").getAsString();
        String password = jsonString.get("password").getAsString();

        try {
            User user = UserFacade.getInstance().getVeryfiedUser(username, password);
            String token = createToken(username, user.getRolesAsStrings());
            JsonObject resObject = new JsonObject();
            resObject.addProperty("username", username);
            resObject.addProperty("token", token);
            
            return Response.ok(new Gson().toJson(resObject)).build();
        } catch (Exception e) {
            if (e instanceof AuthenticationException) {
                throw (AuthenticationException) e;
            }
        }
        throw new AuthenticationException("Invalid username and or password, Please try again");
    }

    private String createToken(String username, List<String> rolesAsStrings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
