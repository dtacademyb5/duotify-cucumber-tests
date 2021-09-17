package apitests;

import com.google.gson.JsonObject;


import io.restassured.common.mapper.TypeRef;
import io.restassured.mapper.ObjectMapperType;
import org.junit.Assert;
import org.junit.Test;
import pojos.VideoGame;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Deserialization {


    @Test
    public void deserializationOfResponseAsList(){

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

//


//        List response = given().log().all().
//
//                header("Accept", "application/json").
//
//                when().log().all().
//                get("/videogames").
//                then().log().all().
//                statusCode(200).extract().as(List.class);
//
//
//        for (Object o : response) {
//            System.out.println(((Map)o).get("name"));
//        }
//
//        System.out.println(((Map)(response.get(0))).get("name"));

        List<Map<String, Object>> response = given().log().all().

                header("Accept", "application/json").

                when().log().all().
                get("/videogames").
                then().log().all().
                statusCode(200).extract().as(new TypeRef<List<Map<String, Object>>>() {
                });


        for (Map<String, Object> stringObjectMap : response) {
            System.out.println(stringObjectMap.get("name"));
        }




    }


    @Test
    public void deserializationOfResponseAsListOfVideoGames(){

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

//


        List<VideoGame> response = given().log().all().

                header("Accept", "application/json").

                when().log().all().
                get("/videogames").
                then().log().all().
                statusCode(200).extract().as(new TypeRef<List<VideoGame>>() {});


        for (VideoGame videoGame : response) {
            System.out.println(videoGame.getName());
        }






    }

    @Test
    public void deserializationOfResponseAsPOJO(){

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

//

        VideoGame responseAsPOJO = given().log().all().

                header("Accept", "application/json").
                pathParam("videoGameId", "8").
                when().log().all().
                get("/videogames/{videoGameId}").
                then().log().all().
                statusCode(200).extract().as(VideoGame.class);

        System.out.println(responseAsPOJO);

        Assert.assertEquals("Life", responseAsPOJO.getName());
        Assert.assertEquals("Strategy", responseAsPOJO.getCategory());
        Assert.assertEquals("GA", responseAsPOJO.getRating());


    }




    @Test
    public void processComplexJsonResponseWithGroovyGpathOrMaps(){


        baseURI = "https://maps.googleapis.com/maps/api";
//        basePath = "/maps/api";


        Map<String, Object> as = given().
                queryParam("input", "Duotech Academy").
                queryParam("inputtype", "textquery").
                queryParam("fields", "photos,formatted_address,name,rating,opening_hours,geometry").
                queryParam("key", "AIzaSyDdNmHK2RgQVbpksSzAFI6A2byAcdm_5l8").
                when().log().all().
                get("/place/findplacefromtext/json").
                then().log().all().
                assertThat().    //syntactic sugar
                        statusCode(200).
                body("candidates[0].geometry.viewport.northeast.lat", equalTo(38.88025452989272F)).
                extract().as(new TypeRef<Map<String, Object>>() {
                });

        List<Map<String,Object>> candidates = (List<Map<String,Object>>)as.get("candidates");

        System.out.println(candidates);


    }



}
