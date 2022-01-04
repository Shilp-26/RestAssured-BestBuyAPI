package com.bestbuy.storesInfo;

import com.bestbuy.testbase.TestBaseStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresGETTest extends TestBaseStores {

    @Test
    public void getAllStoresInfo() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStoreInfo() {
        Response response = given()
                .pathParam("id",4)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
