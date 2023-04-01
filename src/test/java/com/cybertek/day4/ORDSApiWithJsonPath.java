package com.cybertek.day4;

import com.cybertek.utilities.HRTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class ORDSApiWithJsonPath extends HRTestBase {


   @DisplayName("GET request to Countries")
    @Test
    public void test1(){

   Response response = get("/countries");

   //get the second country name with JsonPath

       //to use jsonpath we assign response to JsonPath

       JsonPath jsonPath = response.jsonPath();//alt+enter
    String secondCountryName = jsonPath.getString("items[1].country_name");

       System.out.println("secondCountryName = " + secondCountryName);

       //get all country ids
       //items.country_id
       List<String> allCountryIds = jsonPath.getList("items.country_id");
       System.out.println(allCountryIds);









   }








}
