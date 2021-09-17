package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DELETERequestStepDefs {

    static {
        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";
    }

    RequestSpecification requestSpecification;
    Response reponse;




    @Given("I add header {string} {string}")
    public void iAddHeader(String key, String value) {
        requestSpecification = given().
                header(key, value);


    }
    @Given("I add path parameter video game id {int}")
    public void iAddPathParameterVideoGameId(Integer parameterValue) {
       requestSpecification =
               requestSpecification.given().log().all().
                pathParam("videoGameId", parameterValue);

    }
    @When("I send a DELETE request to {string} endpoint")
    public void iSendADELETERequestToEndpoint(String endpoint) {
        reponse = requestSpecification.when().
                delete(endpoint);
    }

    @Then("the response body {string} should be {string}")
    public void theResponseBodyShouldBe(String status, String message) {

        reponse.then().
                body(status, equalTo(message));

    }

    @Then("The status code should be {int}")
    public void theResponseStatusCodeShouldBe(Integer statusCode) {
        reponse.then().log().all().
                statusCode(statusCode);

    }

    @Then("The header values {string} should be {string}")
    public void theHeaderShouldBe(String key, String value) {
        reponse.then().
                header(key, value);


    }

}
