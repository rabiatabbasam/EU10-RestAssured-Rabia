package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests {

   //BeforeAll is a annotation equals to @beforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){
     //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "http://34.239.249.111:1000/ords/hr";

    }

    @DisplayName("GET request to /regions")
   @Test
   public void test1(){

      Response response = get("/regions");

        //print the status code
        System.out.println(response.statusCode());

    }

    /*
    Given accept type is json
    When user sends get request to regions/2
    Then response status code must be 200
    and content type equals to applications/json
    and response body contains America
     */

    @DisplayName("Get request to /regions/2")
    @Test
    public void test2(){
     Response response =   given().accept(ContentType.JSON)
             .when()

                   .get("regions/2");

     //verify status code
     assertEquals(200,response.statusCode());

       //verify content type
        assertEquals("application/json",response.contentType());

        response.prettyPrint();

        //verify body contains America
        assertEquals(response.body().asString().contains("America"),true);

    }

}