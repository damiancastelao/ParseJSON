import org.json.JSONObject;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.channels.UnresolvedAddressException;

public class EjemploParse {
    public static void main(String args[]){

        // desde donde me traigo JSON
        URI miUri = null;
        HttpResponse<String> response = null;

        try {
            miUri = new URI("https://jsonplaholder.typicode.com/todos/1");

        // creamos la petición
        HttpRequest request = HttpRequest.newBuilder()
                .uri(miUri)
                .GET()
                .build();

        // creamos el cliente
        HttpClient client = HttpClient.newHttpClient();

        // Enviamos la petición y obtenemos la respuesta

        response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (UnresolvedAddressException | InterruptedException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        switch(response.statusCode())
        {
            // todo OK
            case 200 :
                procesaRespuesta(response.body());
                break; // break es opcional
            // no encuentra el recurso
            case 404 :
                System.out.println("No lo encuentro");
                break; // break es opcional
            // hay problema en la conexión
            default :
                System.out.println("La cosa está chunga");
        }

    }

    private static void procesaRespuesta(String body) {
        String cadenaJSON = body;
        // imprimo respuesta
        System.out.println(cadenaJSON);
        // instancio objeto JSON
        JSONObject obj = new JSONObject(cadenaJSON);
        // obtengo valor de la clave 'title'
        String titulo = obj.getString("title");
        System.out.println(titulo);

        /*JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }*/
    }
}
