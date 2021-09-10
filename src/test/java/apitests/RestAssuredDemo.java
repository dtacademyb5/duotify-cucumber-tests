package apitests;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {

    @Test
    public void testRestAssured(){
        // Given I add the header Accept: application/json
        // When I send a GET request to /videogames/{videoGameId} endpoint by passing 4 as videogame id
        // Then the status code should be 200
        // And The id should be 4
        // And The name should be Super Mario 64
//

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

        given().
                header("Accept","application/json").
        when().log().all().
                get("/videogames/4").
        then().log().all().
                statusCode(200).
                body("id", equalTo(4)).
                body("name", is("Super Mario 64"));



    }

}
