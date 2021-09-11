package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class APIDemoStepDefs {

    static {
        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";
    }

    RequestSpecification requestSpecification;
    Response response;


    @Given("I add the header {string} {string}")
    public void iAddTheHeader(String key, String value) {

        requestSpecification = given().
                header("Accept", "application/json");


    }
    @When("I send a GET request to {string} endpoint by passing {int} as videogame id")
    public void iSendAGETRequestToEndpointByPassingAsVideogameId(String endpoint, Integer id) {
       response = requestSpecification.when().log().all().
                get("/videogames/4");




    }
    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(Integer status) {
        response.then().log().all().
                statusCode(200);


    }
    @Then("The id should be {int}")
    public void theIdShouldBe(Integer id) {
        response.then().log().all().
                body("id", equalTo(4));

    }
    @Then("The name should be {string}")
    public void theNameShouldBe(String name) {
        response.then().log().all().
                body("name", is("Super Mario 64"));

    }
}
