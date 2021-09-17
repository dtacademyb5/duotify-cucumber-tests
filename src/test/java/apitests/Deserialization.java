package apitests;

import com.google.gson.JsonObject;
import io.restassured.common.mapper.TypeRef;
import io.restassured.mapper.ObjectMapperType;
import org.junit.Test;
import pojos.VideoGame;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Deserialization {


    @Test
    public void deserializationOfMap(){

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

//


        List<VideoGame> response = given().log().all().

                header("Accept", "application/json").

                when().log().all().
                get("/videogames").
                then().log().all().
                statusCode(200).extract().as(new TypeRef<List<VideoGame>>() {});


//        for (Object o : response) {
//            System.out.println(((Map)o).get("name"));
//        }
//
//        System.out.println(((Map)(response.get(0))).get("name"));

        for (VideoGame videoGame : response) {
            System.out.println(videoGame.getName());
        }


    }


}
