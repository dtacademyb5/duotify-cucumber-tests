package apitests;

import org.junit.Test;
import pojos.VideoGame;

import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class EndToEndAPITest {


    @Test
    public void endToEndTEST() {


        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";


        // Send a POST request


        int id = new Random().nextInt(10000) +2000;
        String name = "Half-Life 3";

        VideoGame videoGame = new VideoGame(id, name, "2031-09-16", 100, "FPS", "PG13");

        given().
                header("Accept","application/json").
                header("Content-Type","application/json").
                body(videoGame).
                when().log().all().
                post("/videogames").
                then().log().all().
                statusCode(200);

        // Verify the created video game by sending GET request
        //@formatter:off
        given().
                header("Accept","application/json").
                pathParam("videoGameId", id).
                when().log().all().
                get("/videogames/{videoGameId}").
                then().log().all().
                statusCode(200).
                body("name", equalTo(name));

        // Send PUT request to update the name and reviewScore

        String newName = "Half-Life: Alyx";
        int newReviewScore = 99;
        VideoGame videoGameUpdated = new VideoGame(id, newName, "2031-09-16", newReviewScore, "FPS", "PG13");


        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(videoGameUpdated).
                pathParam("videoGameId", id).
                when().log().all().
                put("/videogames/{videoGameId}").
                then().log().all().
                statusCode(200);


        // send GET request to verify the Updated fields

        given().
                header("Accept","application/json").
                pathParam("videoGameId", id).
       when().log().all().
                get("/videogames/{videoGameId}").
       then().log().all().
                statusCode(200).
                body("name", equalTo(newName)).
                body("reviewScore", equalTo(newReviewScore));

        // send DELETE request to delete the videogame we just created

        given().
                header("Accept","application/json").
                pathParam("videoGameId", id).
        when().log().all().
                delete("/videogames/{videoGameId}").
        then().log().all().
                statusCode(200).
                body("status", equalTo("Record Deleted Successfully"));

        // send GET request to verify that the game is deleted, get request in this case should NOT return 200

        given().
                header("Accept","application/json").
                pathParam("videoGameId", id).
        when().log().all().
                get("/videogames/{videoGameId}").
        then().log().all().
                statusCode(not(200));







    }

}
