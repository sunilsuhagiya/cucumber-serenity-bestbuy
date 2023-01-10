package com.bestbuy.bestinfo;

import com.bestbuy.steps.StoreSteps;
import com.bestbuy.testbase.TestBaseStores;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.HashMap;


import static org.hamcrest.Matchers.hasValue;

  @RunWith(SerenityRunner.class)
public class StoresCRUDTestWithSteps extends TestBaseStores {

    static String name = "Bye";
    static String type = "Hello";
    static String address = "786 Lindwall";
    static String address2 = "";
    static String city = "Mumbai";
    static String state = "Maharashtra";
    static String zip = "85245";
    static int lat = 987;
    static int lng = 22;
    static String hours = "4";
    static HashMap<String, String> services;
    static int storeId;

    @Steps
    StoreSteps storeSteps;

    @Title("This will create new  store")
    @Test
    public void test001() {
        ValidatableResponse response = storeSteps.addStore(name, type, address, address2, city, state, zip, lat, lng, hours);
        response.log().all().statusCode(201);
        storeId=response.extract().path("id");
        System.out.println(storeId);
    }

    @Title("Getting the store information with Name:")
    @Test
    public void test002() {
        ValidatableResponse response=storeSteps.getStoreById(storeId).statusCode(200);

    }

    @Title("Updating store information and verify the updated information")
    @Test
    public void test003() {
        name = name + ("_added");
        storeSteps.updateStoreByName(storeId, name, type, address, address2, city, state, zip, lat, lng, hours).log().all().statusCode(200);

    }

    @Title("Deleting store with id and verify that user is deleted")
    @Test
    public void test004() {
        storeSteps.deleteStore(storeId).statusCode(200);
        storeSteps.getStoreById(storeId).statusCode(404);

    }
}
