import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ServicioDeConversion {
    public Monedas buscarMoneda (String monedaBase, String monedaTarget){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/156f5d0b831805f3754aefff/pair/" + monedaBase + "/" + monedaTarget);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        }catch (Exception e) {
            throw new RuntimeException("No encontre la Moneda");

        }

    }






































}
//    private static final String API_URL = "https://v6.exchangerate-api.com/v6/156f5d0b831805f3754aefff/latest/USD";
//
//    public double getExchangeRate(String fromCurrency, String toCurrency) throws IOException{
//        String urlString = API_URL + fromCurrency;
//        URL url = new URL(urlString);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("GET");
//
//        int responseCode = connection.getResponseCode();
//        if (responseCode != 200) {
//            throw new IOException("Error al conectarse a la API:" + responseCode);
//        }
//
//        Scanner scanner = new Scanner(url.openStream());
//        StringBuilder jsonResponse = new StringBuilder();
//        while (scanner.hasNext()) {
//            jsonResponse.append(scanner.nextLine());
//        }
//        scanner.close();
//
//        JsonObject data = new JsonObject();
//        return data.getAsJsonObject("rates").getAsDouble();
//    }
//
//    public  double convert(double amount, double rate){
//        return amount * rate;
//    }



