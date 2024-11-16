package test.codingPart.restassuredQues;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RequestSpec_ResponseSpec {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;

    @BeforeTest
    public void setUp() {
        // Set the base URI
        RestAssured.baseURI = "https://api.restful-api.dev/";

        // Create a request specification with headers
        requestSpec = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept-Language", "en-US");

        // Create a response specification
        responseSpec = RestAssured.expect().statusCode(200)
                .contentType("application/json");
    }

    @Test
    public void runGet() {
        // Run GET request
        Response response = requestSpec.when().get("/objects");

        // Validate response with response specification
        response.then().spec(responseSpec);

        // Print response
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Response Code: " + response.getStatusCode());

        // Print response
        System.out.println("ids: " + response.getBody().jsonPath().get("id"));
        System.out.println("ID: " + response.getBody().jsonPath().get("id[0]"));
        System.out.println("color: " + response.getBody().jsonPath().get("data.color"));

    }

    @Test
    public void runGetWithQueryParam() {
        // Run GET request
        Response response = requestSpec.param("id", 1).when().get("/objects");

        // Validate response with response specification
        response.then().spec(responseSpec);

        // Print response
        System.out.println("Response: " + response.getBody().asString());
        System.out.println("Response Code: " + response.getStatusCode());

    }
}
