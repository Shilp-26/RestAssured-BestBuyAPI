package com.bestbuy.productsInfo;

import com.bestbuy.ProductPojo;
import com.bestbuy.testbase.TestBaseProduct;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductsPATCHtest extends TestBaseProduct {

    @Test
    public void updateProductPrice(){

        ProductPojo productPojo =new ProductPojo();
        productPojo.setName("Prime Testers");
        productPojo.setType("Testing");
        productPojo.setPrice(25);
        productPojo.setUpc("041333415521");
        productPojo.setShipping(0);
        productPojo.setDescription("Automation");
        productPojo.setManufacturer("Prime Team");
        productPojo.setModel("MN1500B4Z");
        productPojo.setUrl("http://www.bestbuy.com/site/duracell-aa-1-5v-coppertop-batteries-4-pack/48530.p?id=1099385268988&skuId=48530&cmp=RMXCC");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/4853/48530_sa.jpg");


        Response response = given()
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .patch("/127687");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
