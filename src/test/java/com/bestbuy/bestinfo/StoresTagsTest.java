package com.bestbuy.bestinfo;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class StoresTagsTest extends TestBase {
    @WithTag("storefeature:NEGATIVE")
    @Title("Provide a 500 status code when incorrect HTTP method is used to access resources")
    @Test
    public void invalidMethod(){
        SerenityRest.rest()
                .given()
                .when()
                .post("/stores")
                .then()
                .statusCode(500)
                .log().all();
    }
    @WithTags({
            @WithTag("storefeature:POSITIVE"),
            @WithTag("storefeature:SMOKE")
    })
    @Title("This test will verify if a status code of 200 is returned for GET request")
    @Test
    public void verifyIfTheStatusCodeIs200() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/stores")
                .then()
                .statusCode(200)
                .log().all();
    }
    @WithTags({
            @WithTag("storefeature:NEGATIVE"),
            @WithTag("storefeature:SMOKE")
    })
    @Title("This test will provide an error code of 404 when user tries to access an invalid resource")
    @Test
    public void inCorrectResource() {
        SerenityRest.rest()
                .given()
                .when()
                .get("/stores/9876542")
                .then()
                .statusCode(404)
                .log().all();
    }
}
