import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    Moneda convertirMoneda(TipoDeMoneda monedaInicial, TipoDeMoneda monedaFinal, BigDecimal importe) {
        try {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5212f340e1323f3dfea7b4b7/pair/" + monedaInicial + "/"+ monedaFinal + "/" + importe);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();


            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Moneda moneda = gson.fromJson(response.body(), Moneda.class);

            return moneda;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

//            return new Gson().fromJson(response.body(), Moneda.class);
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }

