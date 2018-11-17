package rest;

import java.util.concurrent.Callable;
import javax.ws.rs.core.Response;

public class ResourceRequest implements Callable{
    private final String jsonRequest;

    public ResourceRequest(String jsonRequest) {
        this.jsonRequest = jsonRequest;
    }

    @Override
    public Response call() throws Exception {
        //do something with the request depending on the type
        return Response.ok(jsonRequest).build();
    }
}
