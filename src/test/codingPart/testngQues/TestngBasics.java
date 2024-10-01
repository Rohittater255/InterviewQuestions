package test.codingPart.testngQues;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngBasics {


    @Test( invocationCount = 5, successPercentage = 80)
    public void sampleTest() {
        System.out.println("Executing test...");
        // Simulate a test that fails 20% of the time
        if (Math.random() > 0.8) {
            throw new RuntimeException("Test failed");
        }
    }

    @Test()
    public void a() {
        String a = "a";
        System.out.println("a " + a);
       // Assert.assertEquals(2,3);
    }
    @Test
    public void A() {
        String A = "A";
        System.out.println("A " + A);
        // Assert.assertEquals(2,3);
    }

    @Test(priority = 1, dependsOnMethods = "a", dataProvider = "testData")
    public void b(String data,String data2, String data3) {
        System.out.println("data " + data);
        System.out.println("data2 " + data2);
        System.out.println("data3 " + data3);
    }

    @DataProvider
    public Object[][] testData() {
        return new Object[][]{
                {"data1", "a","a"},
                {"data2", "a","a"},
                {"data3", "a","a"}
        };
    }

    @Test(priority = 2)
    public void aa() {
        String a = "a";
//        RestAssured.config().sslConfig(new SSLConfig().trustStore("").keyStore(""));
        // Customize connection and socket timeouts
        RestAssured.config().httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 5000) // Connection timeout in milliseconds
                        .setParam("http.socket.timeout", 10000));  // Socket timeout in milliseconds        Response response = RestAssured.given().when().get();
    }

}
