package com.bestbuy.productsInfo;

import com.bestbuy.testbase.TestBaseProduct;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsDELtest extends TestBaseProduct {

    @Test
    public void deleteProduct() {
        Response response = given()
                .when()
                .delete("/9999685");
        response.then().statusCode(200);
        response.prettyPrint();

    }


}
