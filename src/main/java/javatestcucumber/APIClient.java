package javatestcucumber;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



public class APIClient {

    private static String baseUri;

    // Getter for baseUri
    public static String getBaseUri() {
        return baseUri;
    }

    // Setter for baseUri
    public static void setBaseUri(String baseUri) {
        APIClient.baseUri = baseUri;
    }
    public static Response getLatestUSDRates() {
        return given()
                .baseUri(CurrencyExchangeEndpoint.BASE_URL)
                .get(CurrencyExchangeEndpoint.LATEST_USD_ENDPOINT);
    }
}