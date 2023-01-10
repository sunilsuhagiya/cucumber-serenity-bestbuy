package com.bestbuy.cucumber.steps;

import com.bestbuy.steps.ProductSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class ProductsSteps {

    static String name = "hello" + TestUtils.getRandomValue();
    static String type = "Rechargable";
    static int price = 8;
    static int shipping = 4;
    static String upc = "0258";
    static String description = "Compatible with electronic devices";
    static String manufacture = "Duracell";
    static String model = "MN2400B4Z";
    static String url = "http://www.bestbuy.com";
    static String image = "http://img.bbystatic.com";
    static int productId;
    static ValidatableResponse response;

    @Steps
    ProductSteps productSteps;

    @When("^As a User I create a product$")
    public void asAUserICreateAProduct() {
        response = productSteps.addProduct(name, type, price, shipping, upc, description, manufacture, model, url, image);
        productId = (int) response.extract().path("id");
        System.out.println(productId);
    }

    @Then("^User must get back a valid response 201$")
    public void userMustGetBackAValidResponse() {
        response.statusCode(201);

    }


    @When("^I get product with productId$")
    public void iGetProductWithProductId() {
        response=productSteps.getProductById(productId);
    }

    @And("^I must get back a valid response 200$")
    public void iMustGetBackAValidResponse() {
        response.statusCode(200);
    }

    @When("^I update product with productId$")
    public void iUpdateProductWithProductId() {
        name="added_"+name;
        manufacture=manufacture+"_added";
        response=productSteps.updateProduct(productId,name,type,price,shipping,upc,description,manufacture,model,url,image);
    }

    @Then("^I must get back a again valid response 200$")
    public void iMustGetBackAAgainValidResponse() {
        response.statusCode(200);
    }

    @When("^I delete product with productId$")
    public void iDeleteProductWithProductId() {
        response=productSteps.deleteProduct(productId).statusCode(200);
    }

    @And("^I check prodct is deleted$")
    public void iCheckProdctIsDeleted() {
        response=productSteps.getProductById(productId).statusCode(404);
    }
}
