package test.codingPart.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class WiremockPractice_StubbingFromJsonFile {

    @Test()
    public void loadWiremockMappingFromJsonFiles() {

        WireMock.configureFor("localhost", 8080);//Without Https
//        WireMock.configureFor("https","localhost", 8080);//With https

        WireMock wireMock = WireMock.create()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .build();

        // The root directory of the WireMock project, under which the mappings and __files directories should be found
        wireMock.loadMappingsFrom("C:\\Automation\\InterviewQuestions\\src\\test\\codingPart\\wiremock\\");
    }

    @Test(dependsOnMethods = "loadWiremockMappingFromJsonFiles")
    public void singleStubbing_rohitAndYuvraj() {

        Response response = RestAssured.get("http://localhost:8080/cricketer/rohitSharma");
        System.out.println("The wiremock response is " + response.body().asString());

        Response response2 = RestAssured.get("http://localhost:8080/cricketer/yuvrajSingh");
        System.out.println("The wiremock response is " + response2.body().asString());
    }


    @Test(dependsOnMethods = "loadWiremockMappingFromJsonFiles")
    public void multiStubbing_tendulkar() {
        Response response = RestAssured.get("http://localhost:8080/cricketer/tendulkar");
        System.out.println("The wiremock response is " + response.body().asString());

        response = RestAssured.get("http://localhost:8080/cricketer/sachinTendulkar");
        System.out.println("The wiremock response is " + response.body().asString());

        response = RestAssured.get("http://localhost:8080/cricketer/arjunTendulkar");
        System.out.println("The wiremock response is " + response.body().asString());
    }
}
