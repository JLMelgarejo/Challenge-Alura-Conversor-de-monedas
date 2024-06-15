import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la moneda base: ");
        listaDeMonedas();
        int base = entrada.nextInt();
        String monedabase = obtenerCodigoMoneda(base);
        String nombreMonedaUno= nombreDeMoneda(base);
        System.out.println("Ingrese la moneda a convertir: ");
        listaDeMonedas();
        int convertir = entrada.nextInt();
        String monedaConvertir = obtenerCodigoMoneda(convertir);
        String nombreMonedaDos= nombreDeMoneda(convertir);
        System.out.println("¿Cuanto desea convertir?");
        double cantidad = entrada.nextDouble();

        String linkConversion = "https://v6.exchangerate-api.com/v6/4a7c5d5e9f59285711f2b9d5/pair/" + monedabase + "/" + monedaConvertir;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(linkConversion)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        double tasaDeConversion = jsonObject.get("conversion_rate").getAsDouble();
        double resultado = cantidad * tasaDeConversion;
        System.out.println(+cantidad+" "+nombreMonedaUno+" son "+resultado+" "+nombreMonedaDos);
    }

    public static void listaDeMonedas() {
        System.out.println("1.- Dólar estadounidense (USD)");
        System.out.println("2.- Peso mexicano (MXN)");
        System.out.println("3.- Peso argentino (ARS)");
        System.out.println("4.- Sol peruano (PEN)");
        System.out.println("5.- Real brasileño (BRL)");
    }

    public static String obtenerCodigoMoneda(int opcion) {
        switch (opcion) {
            case 1:
                return "USD";
            case 2:
                return "MXN";
            case 3:
                return "ARS";
            case 4:
                return "PEN";
            case 5:
                return "BRL";
            default:
                return "USD"; // Default to USD if an invalid option is chosen
        }
    }

    public static String nombreDeMoneda(int opcionNombre){
        switch (opcionNombre) {
            case 1:
                return "Dolares";
            case 2:
                return "Pesos mexicanos";
            case 3:
                return "Pesos argentinos";
            case 4:
                return "Soles peruanos";
            case 5:
                return "Reales brasileños";
            default:
                return "USD"; // Default to USD if an invalid option is chosen
        }
    }
}