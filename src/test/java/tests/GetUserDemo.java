package tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetUserDemo {
	
	static {
		RestAssured.useRelaxedHTTPSValidation();
	}

    @Test
    public void getUser() {

        given()

        .when()
            .get("https://reqres.in/api/users/2")

        .then()
            .statusCode(200)
            .log().body();

        System.out.println("GET Request Successful");
    }
    
    
    
}