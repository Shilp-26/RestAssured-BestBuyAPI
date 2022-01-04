package com.bestbuy.myfirsttest;


import com.bestbuy.testbase.TestBaseProduct;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MyFirstTest extends TestBaseProduct {

    @Test
    public void getAllStudentInfo() {
//        given()
//                .when()
//                .get("http://localhost:8080/student/list")
//                .then()
//                .statusCode(200);
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();


    }
}
