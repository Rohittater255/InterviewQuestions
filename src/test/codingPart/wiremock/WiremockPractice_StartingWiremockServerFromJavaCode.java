package codingPart.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WiremockPractice_StartingWiremockServerFromJavaCode {

    @Test
    public void wiremockEndToEnd() {
        // Start WireMock server
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8090));
        wireMockServer.start();

        // Configure WireMock
        WireMock.configureFor("localhost", 8090);

        // Stub for /cricketer/tendulkar
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/cricketer/tendulkar"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"cricketers\": [{\"name\": \"Sachin Tendulkar\", \"age\": 50, \"Number of 100s\": 100}, {\"name\": \"Arjun Tendulkar\", \"age\": 20, \"Number of 100s\": 0}], \"description\": \"Information about Sachin Tendulkar and Arjun Tendulkar\"}")));

        // Add more stubs as needed...
        Response response = RestAssured.get("http://localhost:8090/cricketer/tendulkar");
        System.out.println("The wiremock response is " + response.body().asString());
        // Keep the server running
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            wireMockServer.stop();
        }));
    }




}
