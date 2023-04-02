package com.cybertek.day4;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class CBTrainingWithJsonPath {

    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "https://api.training.cydeo.com";

    }


    @DisplayName("GET request to individual student")
    @Test
    public void test1(){

        //send a get request to student id is 67 as a path parameter and accept header application/json
        //verify status code =200 /content type=application/json;charset=UTF-8 /Content-Encoding = gzip
        //verify Date header exists
        //assert that
        /*
        firstName ali
         batch 2
         section ddddd
         emailAddress glc@gmail.com
          companyName string
           state kkkkk
            zipCode  15

            using JsonPath
         */

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",67)
                .when().get("/student/{id}");

        System.out.println(response.statusCode());
        assertEquals(200,response.statusCode());
        assertEquals("application/json;charset=UTF-8",response.contentType());
        System.out.println(response.header("date"));

        // response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
      /*
        String firstName = jsonPath.getString("students[0].firstName");

        System.out.println("firstName = " +firstName );
      String batchNo = jsonPath.getString("students[0].batch");
      String section = jsonPath.getString("students[0].section");
      String emailAdd = jsonPath.getString("students[0].contact.emailAddress");
      String companyName = jsonPath.getString("students[0].company.companyName");
      String zipCode = jsonPath.getString("students[0].company.address.zipCode");
      String state = jsonPath.getString("students[0].company.address.state");

        System.out.println("batchNo = " + batchNo);
        System.out.println("section = " + section);
        System.out.println("emailAdd = " + emailAdd);
        System.out.println("companyName = " + companyName);
        System.out.println("zipCode = " + zipCode);
        System.out.println("state = " + state);
     */
        assertEquals("ali",jsonPath.getString("students[0].firstName"));
    }
}
