package apitests;

import org.junit.Test;
import pojos.VideoGame;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Serialization {


    @Test
    public void serializationOfMap(){

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

//        {
//  "id": 2222,
//  "name": "Half-Life 3",
//  "releaseDate": "2031-09-16",
//  "reviewScore": 100,
//  "category": "FPS",
//  "rating": "PG13"

//}

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id" , 3000+ (int)(Math.random()*10000));
        map.put("releaseDate" , "2031-09-16");
        map.put("name" , "Half-Life 3");
        map.put("reviewScore" ,100);
        map.put("category" , "FPS");
        map.put("rating" , "PG13");


            given().log().all().
                    header("Content-Type", "application/json").
                    header("Accept", "application/json").
                    body(map).
            when().log().all().
                    post("/videogames").
            then().log().all().
                    statusCode(200);

    }


    @Test
    public void sendPayloadasPOJO(){

        baseURI = "http://ec2-3-16-159-241.us-east-2.compute.amazonaws.com:8080/app";

     // POJO = PLain Old Java Object

//{
//  "id": 2222,
//  "name": "Half-Life 3",
//  "releaseDate": "2031-09-16",
//  "reviewScore": 100,
//  "category": "FPS",
//  "rating": "PG13"
//}

//        VideoGame videoGame = new VideoGame(3000+ (int)(Math.random()*10000),
//                "Half-Life 3", "2031-09-16", 100, "FPS", "PG13");

//        VideoGame videoGame = new VideoGame();
//        videoGame.setId(7324657);
//        videoGame.setName("Half_Life");
//        videoGame.setReleaseDate("1998-09-16");
//        videoGame.setReviewScore(99);

        VideoGame videoGame = new VideoGame();
        videoGame.setId(7324659);
        videoGame.setName("Half_Life");


        given().log().all().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(videoGame).
        when().log().all().
                post("/videogames").
        then().log().all().
                statusCode(200);

    }
}
