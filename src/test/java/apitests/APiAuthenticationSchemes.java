package apitests;

import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import utilities.ConfigReader;

import java.util.Base64;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class APiAuthenticationSchemes {



    @Test
    public void apiKeyAuth(){

        // To authenticate thru an API key the client needs to sign up for an API key


        baseURI = "https://maps.googleapis.com/maps/api";

String place ="Java Loco Coffee & Bubble Tea - Tysons Station";

      given().
                queryParam("input", place ).
                queryParam("inputtype", "textquery").
                queryParam("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
                queryParam("key", ConfigReader.getProperty("api_key")).
                when().log().all().
                get("/place/findplacefromtext/json").
                then().log().all().
                assertThat().
                        statusCode(200).
                        body("candidates[0].name.toString()", is(place));


                 // base uri > api.videos.com
                // query parameter ->  ?type=json              Example: https://api.videos.com/videos/8?type=json
                // path parameter ->  /videos/{videoGameId}    Example: https://api.videos.com/videos/8






    }


    @Test
    public void basicAuth(){


        baseURI = "https://postman-echo.com";



//        String encode = Base64.getEncoder().encodeToString((username + “:” + password).getBytes());

        given().
               auth().basic("postman", "password").
//              header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==").
                when().log().all().
                get("/basic-auth").
                then().log().all().
                assertThat().
                statusCode(200).
                body("authenticated", is(true));

    }


    @Test
    public void OAuth2Point0Test(){

        //Send a post request to authorization server to obtain access token


        String authorization_code = "AQDkGmy-VlDpq2FXBNOldy66paDMe_xLsaezkijRNTy7-mUtzgNypoEJvkLsKUrLrKRbQWahg8TgNBQBENDncG_qn-YvOM6act85_gFZxf_2n3w4o1v479lUsl9YCml-LF2hZTcyN62Et5U_1RmzWKRHZRMV5RRLcOdzZyuMc32Qoy3TPQoF_wR-8pnUb5uqGfuzQgp-yA1lBXMe7vY2bJn3asWue6b-bHehzzK_TlxSbIqY2zC7tYz2RCGTSWI2sSqeyzd7uamzqVlIo_01gruPYwExvEOJqyP8wOShqpA";
        JsonPath jsonPath = given().
                formParam("grant_type", "authorization_code").
                formParam("code", authorization_code).
                formParam("redirect_uri", "https://www.duotech.io/").
                formParam("client_id", "6ac0c69deaa54ca8b43e6c6fb52f6340").
                formParam("client_secret", "7cd5f6e4ec0f496e8ea2c5034bb3f01d").
                when().log().all().
                post("https://accounts.spotify.com/api/token").
                then().log().all().
                assertThat().
                statusCode(200).extract().jsonPath();

        String access_token = jsonPath.get("access_token");

        // Extract the access token from the response

        // Send get request to playlists api

//        https://api.spotify.com/v1/me/playlists

        JsonPath response = given().
                header("Authorization", "Bearer " + access_token).
                when().log().all().
                get(" https://api.spotify.com/v1/me/playlists").
                then().log().all().
                assertThat().
                statusCode(200).extract().jsonPath();


       List list =  response.get("items.name");


        for (Object o : list) {
            System.out.println(o);
        }

    }




}
