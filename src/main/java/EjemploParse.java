import org.json.JSONArray;
import org.json.JSONObject;

public class EjemploParse {
    public static void main(String args[]) {
        String cadenaJSON =
                "{ \"pageInfo\": { \"pageName\": \"Homepage\", \"logo\": \"https://www.example.com/logo.jpg\"}, " +
                  "\"posts\":"+
                    "[" +
                        "{" +
                            " \"post_id\": \"0123456789\", " +
                            " \"actor_id\": \"1001\", " +
                            " \"author_name\": \"Jane Doe\" , " +
                            " \"post_title\": \"How to parse JSON in Java\", " +
                            " \"comments\": [{\"comment\":\"Muy Bueno\"},{\"comment\":\"Bueno, mas o menos\"}], " +
                            " \"time_of_post\": \"1234567890\" " +
                        "}," +
                        "{" +
                            " \"post_id\": \"AAASSSS789\", " +
                            " \"actor_id\": \"1001\", " +
                            " \"author_name\": \"Jane Doe\" , " +
                            " \"post_title\": \"How to parse JSON in Java\", " +
                            " \"comments\": [{\"comment\":\"GENIAL!!!!!\"},{\"comment\":\"ERES UN CRACK!\"}], " +
                            " \"time_of_post\": \"1234567890\" " +
                        "}" +
                  "]" +
                "}";
        JSONObject obj = new JSONObject(cadenaJSON);

        String vivo = obj.getJSONObject("pageInfo").getString("pageName");

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }

        System.out.println(vivo);
    }
}
