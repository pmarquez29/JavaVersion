package arquitectura.software.demo2.bl;

import arquitectura.software.demo2.dto.CurrencyDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class CurrencyBl {
    public CurrencyDto get(String from, String to, BigDecimal amount) throws IOException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("EL MONTO NO PUEDE SER MENOR O IGUAL A CERO");
        }
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?from=" + from + "&to=" + to + "&amount=" + amount)
                .addHeader("apikey", "hvQIMf7LSCxyyLMJ0mDuLSsihHDEcDej")
                .build();

        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);

        ObjectMapper mapper = new ObjectMapper();
        CurrencyDto currencyDto = mapper.readValue(result, CurrencyDto.class);
        return currencyDto;
        //return null;
    }
}
