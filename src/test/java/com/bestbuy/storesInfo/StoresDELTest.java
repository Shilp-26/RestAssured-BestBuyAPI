package com.bestbuy.storesInfo;


import com.bestbuy.testbase.TestBaseStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresDELTest extends TestBaseStores {

    @Test
    public void deleteStore() {
        Response response = given()
                .when()
                .delete("/8924");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
