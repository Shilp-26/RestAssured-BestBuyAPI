package com.bestbuy.storesInfo;


import com.bestbuy.ProductPojo;
import com.bestbuy.StoresPojo;
import com.bestbuy.testbase.TestBaseStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPOSTTest extends TestBaseStores {

    @Test
    public void createStore() {
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Sudbury");
        storesPojo.setType("Prime");
        storesPojo.setAddress("26 Harrow rd");
        storesPojo.setAddress2("Sudbury Town");
        storesPojo.setCity("Sudbury");
        storesPojo.setState("MN");
        storesPojo.setZip("88655");
        storesPojo.setLat(44.879314);
        storesPojo.setLng(-93.077156);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9;");


        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

        //8924
    }
}
