package rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Callable;
import javax.ws.rs.core.Response;

public class SwapiResourceRequest implements Callable {

    private final String requestUrl;

    public SwapiResourceRequest(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public Response call() throws IOException{
        //do something with the request depending on the type
        String data = getSwapiData(requestUrl);
        return Response.ok(data).build();
    }

    private String getSwapiData(String path) throws MalformedURLException, IOException {
        URL url = new URL("https://swapi.co/api" + path);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
}
