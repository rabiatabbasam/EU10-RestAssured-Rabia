package com.cybertek.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class SpartanTestBase {
    //BeforeAll is a annotation equals to @beforeClass in testNg, we use with static method name
    @BeforeAll
    public static void init(){
        //save baseurl inside this variable so that we don't need to type each http method.
        baseURI = "http://34.239.249.111:8000";

        String dbUrl = "jdbc:oracle:thin:@34.239.249.111:1521:XE";
        String dbUsername = "SP";
        String dbPassword = "SP";

       // DBUtils.createConnection(dbUrl,dbUsername,dbPassword);

    }

    @AfterAll
    public static void teardown(){

        //DBUtils.destroy();
    }
}
