package apitests;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
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

       baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

       given().
                header("Accept","application/json").
        when().log().all().
                get("/videogames/4").
        then().log().all().
                statusCode(200).
                body("id", equalTo(4)).
                body("name", is("Super Mario 64"));

//        {
//                "id": 4,
//                "name": "Super Mario 64",
//                "releaseDate": "1996-10-20",
//                "reviewScore": 90,
//                "category": "Platform",
//                "rating": "Universal"
//        }





















        //  RequestSpecification requestSpecification = given().
        //                header("Accept", "application/json");
        //
        //
        //        Response response = requestSpecification.when().log().all().
        //                get("/videogames/4");
        //
        //
        //        response.then().log().all().
        //                statusCode(200).
        //                body("id", Matchers.equalTo(4)).
        //                body("name", Matchers.is("Super Mario 64"));



    }



    @Test
    public void getPlaceGoogleMapsAPI(){


        baseURI = "https://maps.googleapis.com/maps/api";
//        basePath = "/maps/api";



        given().
                queryParam("input", "Duotech Academy").
                queryParam("inputtype", "textquery").
                queryParam("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
                queryParam("key", "AIzaSyDdNmHK2RgQVbpksSzAFI6A2byAcdm_5l8").
        when().log().all().
                get("/place/findplacefromtext/json").
        then().log().all().
                assertThat().    //syntactic sugar
                statusCode(200).
                body("status", equalTo("OK")).
//                body("candidates[0].formatted_address", equalTo("2735 Hartland Rd Suite 302, Falls Church, VA 22043, United State")).
                body("candidates[0].geometry.location.lat", equalTo(38.878937F));

    }

}
