package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PUTRequestEndpointsStepDefs {

static{
    baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";
}


    Response response;
    Map<String, String> map;
    Integer idExpected;
    RequestSpecification requestSpecification;


    @Given("I add the header {string} {string} and header {string}  {string} and parameter {string} with value {int} and the following payload")
    public void iAddTheHeaderAndHeaderAndParameterWithValue(String key1, String value1, String key2, String value2, String key3, Integer value3, List<Map<String,String>> dataTable ) {
        idExpected = value3;
        map = dataTable.get(0);

        requestSpecification = given().log().all().
                header(key1, value1).
                header(key2, value2).
                pathParam(key3, value3).
                body("{\n" +
                        "  \"id\": "+value3+",\n" +
                        "  \"name\": \"" + map.get("name") + "\",\n" +
                        "  \"releaseDate\": \"" + map.get("releaseDate") + "\",\n" +
                        "  \"reviewScore\": " + map.get("reviewScore") + ",\n" +
                        "  \"category\": \"" + map.get("category") + "\",\n" +
                        "  \"rating\": \"" + map.get("rating") + "\"\n" +
                        "}");
    }


    @When("I send a PUT request to {string} endpoint")
    public void iSendTheFollowingPayloadAPUTRequestToEndpointWithAnId(String endpoint) {
       response = requestSpecification.when().log().all().
                put(endpoint);

    }
    @Then("The response status code should be {int}")
    public void theResponseStatusCodeShouldBe(Integer statusCode) {
        response.then().log().all().
                statusCode(statusCode);

    }
    @Then("The response body should contain the same data")
    public void theResponseBodyShouldContainTheSameData() {
        response.then().
                body("id", equalTo(idExpected)).
                body("name", equalTo(map.get("name"))).
                body("releaseDate", equalTo(map.get("releaseDate"))).
                body("category", equalTo(map.get("category"))).
                body("rating", equalTo(map.get("rating")));
    }
    @Then("The header {string} should be {string}")
    public void theHeaderShouldBe(String key, String value) {
        response.then().
                header(key, value);


    }
    @Then("The response should be returned less than {int} seconds")
    public void theResponseShouldBeReturnedLessThanSeconds(Integer seconds) {
        response.then().
                time(lessThan(seconds*1000L));
    }





}
