import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConversao {
    public static void Moeda(Referencias referencias){
        String chaveApi = "AQUI-CHAVE-DA-API";
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        try{
            URI endereco = URI.create("https://v6.exchangerate-api.com/v6/"+chaveApi+"/pair/"+ referencias.getConverterDe()
                    +"/"+ referencias.getConverterPara()+"/"+ referencias.getQuantia());
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(endereco)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Conversao conversao = gson.fromJson(json, Conversao.class);
            System.out.println(conversao);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
