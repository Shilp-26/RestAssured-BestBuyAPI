package com.bestbuy.productsInfo;

import com.bestbuy.testbase.TestBaseProduct;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsGETtest extends TestBaseProduct {

    @Test
    public void getAllProductsInfo() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProductInfo() {
        Response response = given()
                .pathParam("id",127687)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

//    @Test
//    public void searchProductWithParameter() {
//        HashMap<String, Object> qParams =new HashMap<>();
//        qParams.put("manufacturer","Duracell");
//        qParams.put("limit",3);
//
//        Response response = given()
//                .queryParams(qParams)
//                .when()
//                .get("/products");
//        response.then().statusCode(200);
//        response.prettyPrint();
//    }


}
