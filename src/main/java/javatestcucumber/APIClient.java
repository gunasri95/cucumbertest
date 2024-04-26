package javatestcucumber;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



public class APIClient {
    public static Response getLatestUSDRates() {
        return given()
                .baseUri(CurrencyExchangeEndpoint.BASE_URL)
                .get(CurrencyExchangeEndpoint.LATEST_USD_ENDPOINT);
    }
}