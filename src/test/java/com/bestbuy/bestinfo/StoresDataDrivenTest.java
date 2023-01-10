package com.bestbuy.bestinfo;

import com.bestbuy.constants.Path;
import com.bestbuy.steps.ProductSteps;
import com.bestbuy.steps.StoreSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.testbase.TestBaseStores;
import com.bestbuy.utils.PropertyReader;
import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

//Faster execution
//@Concurrent(threads = "2x")
//// Use content root path for locating file
@UseTestDataFrom("src/test/java/resources/testdata/stores.csv")
//// When using data driven using SerenityParameterizedRunner
//// Run test at class level to create students
@RunWith(SerenityParameterizedRunner.class)

public class StoresDataDrivenTest extends TestBaseStores{

    private String name;
    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private int lat;
    private int lng;
    private String hours;

    @Steps
    StoreSteps storeSteps;

    @Title("Data driven test for adding multiple products to the application")
    @Test
    public void createMultipleProducts(){
        storeSteps.addStore(name,type,address,address2,city,state,
                zip,lat,lng,hours).statusCode(201);
    }
}
