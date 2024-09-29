package test.codingPart.restassuredQues;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RestAssuredFramework {

    @Test
    public void setSSL() {
        //Disable SSL
        RestAssured.useRelaxedHTTPSValidation();

        //Use SSL
//        RestAssured.config().sslConfig(new SSLConfig().keyStore("filepath","password").trustStore("filepath","password"));
    }

    @Test
    public void setConnectionTimeOut() {

        //Set Connection and Socket timeout
        RestAssured.config().
                httpClient(HttpClientConfig.httpClientConfig().
                        setParam("http.socket.timeout", 1000).
                        setParam("http.connection.timeout", 1000));
    }

    @Test
    public void runGet() {
        //Run Get
        Response response = RestAssured.given().when().get("https://api.restful-api.dev/objects");
        System.out.println("Response:- " + response.getBody().asString());
        System.out.println("Response Code:- " + response.statusCode());
        //Run Get
//        Response response=RestAssured.given().when().get("").asInputStream();
    }


    @Test
    public void runGet2() {
        //Run Get
        Response response = RestAssured.given().header("Content-Type", "application/json").
                            pathParam("", "").
                            queryParam("limit", 10).  // Set the limit
                            queryParam("offset", 20). // Set the offset
                            when().
                           get("https://api.restful-api.dev/objects");
        System.out.println("Response:- " + response.getBody().asString());
        System.out.println("Response Code:- " + response.statusCode());
        //Run Get
//        Response response=RestAssured.given().when().get("").asInputStream();
    }

}
