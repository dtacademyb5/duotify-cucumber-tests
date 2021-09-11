package apitests;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.*;

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
                body("candidates[0].geometry.location.lat", equalTo(38.878937F)).
                body("status", notNullValue()).
                time(greaterThan(1000L) ).
                time(not(lessThan(2000L)));

        // time(not(lessThan(2000L)));  to flip the matcher condition

    }

    @Test
    public void verifyVideoGameTitles() {

        // Verify that the returned response contains videogames with name Resident Evil 4, Gran Turismo 3, Super Mario 64
        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

        given().
                header("Accept", "application/json").
                when().log().all().
                get("/videogames").
                then().log().all().
                body("name" ,hasItems("Resident Evil 4", "Gran Turismo 3", "Super Mario 64")).
                body("name" ,hasItem("Doom")).
                body("name" ,not(hasItem("Half Life 3"))).
//                body("name" ,contains("COD Warzone")).
//                body("name" , hasSize(23)).
                statusCode(200);



        given().
                header("Accept", "application/json").
                when().log().all().
                get("/videogames").
                then().log().all().
                body("[1]" , hasKey("name")).
                body("[1]" , hasValue("Resident Evil 4")).
                body("[1]" , hasEntry("reviewScore", 85)).
                statusCode(200);





    }


    @Test
    public void verifyVideoGameTitlesByExtractingResponse() {


        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

        Map map =
                given().
                header("Accept", "application/json").
                when().log().all().
                get("/videogames/4").
                then().log().all().
//                statusCode(200).extract().asString();
//                statusCode(200).extract().asPrettyString();
                 statusCode(200).extract().as(Map.class);

        System.out.println(map);

        System.out.println(map.get("reviewScore"));
        System.out.println(map.get("name"));


    }


    @Test
    public void verifyVideoGameTitlesByExtractingResponseAsList() {


        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

        List list =
                given().
                        header("Accept", "application/json").
                        when().log().all().
                        get("/videogames").
                        then().log().all().
//                statusCode(200).extract().asString();
//                statusCode(200).extract().asPrettyString();
        statusCode(200).extract().as(List.class);

        System.out.println(list);
        System.out.println(list.get(1));




    }

    @Test
    public void verifyVideoGameTitlesByExtractingResponseAsJsonPathObject() {


        baseURI = "https://maps.googleapis.com/maps/api";
//        basePath = "/maps/api";


        JsonPath jsonPathResponse = given().
                queryParam("input", "Duotech Academy").
                queryParam("inputtype", "textquery").
                queryParam("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
                queryParam("key", "AIzaSyDdNmHK2RgQVbpksSzAFI6A2byAcdm_5l8").
                when().log().all().
                get("/place/findplacefromtext/json").
                then().log().all().
                assertThat().    //syntactic sugar
                        statusCode(200).extract().jsonPath();


        Object o = jsonPathResponse.get("candidates.name");

        System.out.println(o);

//









    }




    @Test
    public void postRequestExampleBodyAsString(){

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";
         int id = new Random().nextInt(10000) +2000;
        given().
                header("Accept","application/json").
                header("Content-Type","application/json").
                body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"name\": \"Mario Kart\",\n" +
                        "  \"releaseDate\": \"2021-09-10\",\n" +
                        "  \"reviewScore\": 98,\n" +
                        "  \"category\": \"Arcade\",\n" +
                        "  \"rating\": \"GA\"\n" +
                        "}").
        when().log().all().
                post("/videogames").
        then().log().all().
                statusCode(200).
                body("status", is("Record Added Successfully"));

    }


    @Test
    public void postRequestExampleBodyAsMap(){
        int id = new Random().nextInt(10000) +2000;
        //We can also use JsonObject class
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("id", id);
//        jsonObject.addProperty("name", "Dangerous Game");
//        jsonObject.addProperty("releaseDate", "2021-09-10");
//        jsonObject.addProperty("reviewScore", 88);
//        jsonObject.addProperty("category", "FPS");
//        jsonObject.addProperty("rating", "PG13");

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", id);
        map.put("name", "Dangerous Game");
        map.put("releaseDate", "2021-09-10");
        map.put("reviewScore", 88);
        map.put("category", "FPS");
        map.put("rating", "PG13");

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

        given().
                header("Accept","application/json").
                header("Content-Type","application/json").
                body(map).
//                body(new File("C:\\Users\\Nuclues\\IdeaProjects\\duotify-bdd-tests\\src\\test\\java\\apitests\\payload.json")).
                when().log().all().
                post("/videogames").
                then().log().all().
                statusCode(200).
                body("status", is("Record Added Successfully"));

    }


}
