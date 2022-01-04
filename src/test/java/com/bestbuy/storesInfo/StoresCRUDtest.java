package com.bestbuy.storesInfo;

import com.bestbuy.StoresPojo;
import com.bestbuy.testbase.TestBaseStores;
import com.bestbuy.utils.TestUtils;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StoresCRUDtest extends TestBaseStores {

    static String name = "Sudbury" + TestUtils.getRandomValue();
    static String type = "Grocery Store" + TestUtils.getRandomValue();
    static String address = TestUtils.getRandomValue() + ", Pinner road";
    static String address2 = "Harrow";
    static String city = "London";
    static String state = "London";
    static String zip = "123456";
    static Double lat = 45.126179;
    static Double lng = -93.261429;
    static String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-6; Sun: 10-6";
    static int storeId;

    @Test
    public void test001() {

        StoresPojo storesPojo = new StoresPojo(); // create object of StorePojo class
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    //Get Store id of new added Store in Test001 and store in StoreId variable
    @Test
    public void test002() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";


        HashMap value =
                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name + p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
        storeId = (int) value.get("id");
    }

    //update name,type,address using storeId -- (PUT) method and verify that its updated
    @Test
    public void test003() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";

        //update
        name = name + "_updated";   //name update
        type = type + "_updated";//type update
        address = address + "_updated";//address update
        address2 = address2 + "_updated";//address update

        StoresPojo storesPojo = new StoresPojo(); // create object of StorePojo class
        storesPojo.setName(name);
        storesPojo.setType(type);
        storesPojo.setAddress(address);
        storesPojo.setAddress2(address2);
        storesPojo.setCity(city);
        storesPojo.setState(state);
        storesPojo.setZip(zip);
        storesPojo.setLat(lat);
        storesPojo.setLng(lng);
        storesPojo.setHours(hours);

        given()
                .header("Content-Type", "application/json")
                .pathParam("storeID", storeId)
                .body(storesPojo)
                .when()
                .put("/{storeID}")
                .then().log().all().statusCode(200);

        //verify that response through id with after  extract by Name
        HashMap<String, Object> value =

                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name + p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
    }

    //delete new added store record and verify that record deleted successfully
    @Test
    public void test004(){

        given()
                .pathParam("storeID", storeId)
                .when()
                .delete("/{storeID}")
                .then()
                .statusCode(200);

        given()
                .pathParam("storeID", storeId)
                .when()
                .get("/{storeID}")
                .then()
                .statusCode(404);

    }

}
