package com.cybertek.day5;

import com.cybertek.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SpartanHamcrestTest extends SpartanTestBase {

    @DisplayName("GET Spartan/search and chaining together")
    @Test
    public void test1(){

    //along with this statement,I want to save names inside the List<String>
   List<String> names =  given().accept(ContentType.JSON)
                .and().queryParams("nameContains","P",
                        "gender","Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .and()
                .body("totalElements",greaterThanOrEqualTo(3))
                .extract().response().jsonPath().getList("content.name");

        System.out.println(names);


    }

    @Test
    public void test2(){

        //save status code
        int statusCode =  given().accept(ContentType.JSON)
                .and().queryParams("nameContains","P",
                        "gender","Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .and()
                .body("totalElements",greaterThanOrEqualTo(3))
                .extract().response().statusCode();

        System.out.println(statusCode);


    }






}
