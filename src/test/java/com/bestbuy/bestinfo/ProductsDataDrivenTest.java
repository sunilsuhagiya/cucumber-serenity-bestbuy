package com.bestbuy.bestinfo;

import com.bestbuy.steps.ProductSteps;
import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

//Faster execution
@Concurrent(threads = "2x")
//// Use content root path for locating file
@UseTestDataFrom("src/test/java/resources/testdata/products.csv")
//// When using data driven using SerenityParameterizedRunner
//// Run test at class level to create students
@RunWith(SerenityParameterizedRunner.class)
public class ProductsDataDrivenTest extends TestBase {

    private String name;
    private String type;
    private int price;
    private int shIpping;
    private String upc;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;

    @Steps
    ProductSteps productSteps;

    @Title("Creating multiple products with Data driven")
    @Test
    public void createMultipleProduct() {
        productSteps.addProduct(name, type, price, shIpping, upc, description, manufacturer, model, url, image).statusCode(201);
    }

}
