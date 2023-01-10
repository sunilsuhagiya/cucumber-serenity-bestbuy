package com.bestbuy.bestinfo;

import com.bestbuy.steps.ProductSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ProductsCRUDTestWithSteps extends TestBase {

    static String name = "Duracell" + TestUtils.getRandomValue();
    static String type = "Charged";
    static int price = 2;
    static int shipping = 6;
    static String upc = "0124";
    static String description = "Compatible with electronic devices";
    static String manufacture = "Duracell";
    static String model = "MN2400B4Z";
    static String url = "http://www.bestbuy.com";
    static String image = "http://img.bbystatic.com";
    static int productId;

    @Steps
    ProductSteps productSteps;

    @Title("This will create new product")
    @Test
    public void test001() {
        ValidatableResponse response = productSteps.addProduct(name, type, price, shipping, upc, description, manufacture, model, url, image);
        response.log().all().statusCode(201);
        productId= response.extract().path("id");
        System.out.println(productId);
    }

    @Title("Getting the product information with id:")
    @Test
    public void test002() {

        ValidatableResponse response=productSteps.getProductById(productId).statusCode(200);

    }

    @Title("Updating product information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_add";
        productSteps.updateProduct(productId, name, type, price, shipping, upc, description, manufacture, model, url, image)
                .log().all().statusCode(200);

    }

    @Title("Deleting product with id and verify that user is deleted")
    @Test
    public void test004() {
        productSteps.deleteProduct(productId).statusCode(200);
        productSteps.getProductById(productId).statusCode(404);
    }


    @Title("Update Product name by ID")
    @Test
    public void test03_updateProduct() {
        name= "heloo" + TestUtils.getRandomValue();
        type="possible" + TestUtils.getRandomValue();
        productSteps.updateProduct(productId,name,type,price,shipping,upc,description,manufacture,model,url,image);

    }

    @Title("Delete Product name by ID")
    @Test
    public void test04_deleteProduct() {
        productSteps.deleteProduct(productId);

    }
}
