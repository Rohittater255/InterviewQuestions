package test.codingPart.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WiremockPractice_StubbingFromJavaCode {

    @Test(priority = 0)
    public void loadWiremockMappingFromJavaCode() {
        WireMock.configureFor("localhost", 8080);//Without Https
//        WireMock.configureFor("https","localhost", 8080);//With https

        WireMock wireMock = WireMock.create()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .build();


        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/football/ronaldo")).
                willReturn(WireMock.aResponse().
                        withStatus(200).
                        withHeader("Content-Type", "application/json").
                        withBody("{\"name\": \"Cristiano Ronaldo\", \"age\": 39,  \"Number of Goals\": 1000\n}")));

        Response response = RestAssured.get("http://localhost:8080/football/ronaldo");
        System.out.println("The wiremock response is " + response.body().asString());

    }


}
