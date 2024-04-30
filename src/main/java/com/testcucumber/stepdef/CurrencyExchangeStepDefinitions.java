package com.testcucumber.stepdef;

import org.junit.Assert;

import org.json.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import javatestcucumber.APIClient;
import javatestcucumber.JsonSchemaValidator;

public class CurrencyExchangeStepDefinitions {

    private Response response;


    // Getter for response
    public Response getResponse() {
        return response;
    }

    // Setter for response
    public void setResponse(Response response) {
        this.response = response;
    }

    @Given("^I make a GET request to the latest USD rates endpoint$")
    public void makeGETRequestToLatestUSDRatesEndpoint() {
        response = APIClient.getLatestUSDRates();
    }
    @Then("^the status code should be (\\d+)$")
    public void validateStatusCode(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Then("^the API response status should be \"([^\"]*)\"$")
    public void validateAPIResponseStatus(String expectedStatus) {
        JSONObject responseBody = new JSONObject(response.getBody().asString());
        Assert.assertEquals(responseBody.getString("status"), expectedStatus);
    }

    @Then("^the API response time should not be less than (\\d+) seconds$")
    public void validateResponseTime(int expectedResponseTime) {
        Assert.assertTrue(response.time() >= expectedResponseTime * 1000);
    }

    @Then("^the number of currency pairs should be (\\d+)$")
    public void validateCurrencyPairsCount(int expectedCount) {
        JSONObject responseBody = new JSONObject(response.getBody().asString());
        Assert.assertEquals(responseBody.getJSONObject("rates").length(), expectedCount);
    }

    @Then("^the USD price against AED should be in the range of (\\d+.\\d+) to (\\d+.\\d+)$")
    public void validateUSDPriceRangeForAED(double minRange, double maxRange) {
        JSONObject responseBody = new JSONObject(response.getBody().asString());
        double aedRate = responseBody.getJSONObject("rates").getDouble("AED");
        Assert.assertTrue(aedRate >= minRange && aedRate <= maxRange);
    }

    @Then("^the API response should match the JSON schema$")
    public void validateResponseSchema() {
        JSONObject responseBody = new JSONObject(response.getBody().asString());
        Assert.assertTrue(JsonSchemaValidator.validateResponseSchema(responseBody, "/schema/currency_exchange_schema.json"));
    }
}