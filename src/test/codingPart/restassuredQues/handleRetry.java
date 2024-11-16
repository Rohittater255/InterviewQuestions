package test.codingPart.restassuredQues;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class handleRetry {

    private final int maxRetries = 3;

    @BeforeTest
    public void handleRetryLogic() {
        // Configure failure listener
        RestAssured.config = RestAssured.config()
                .failureConfig(FailureConfig.failureConfig().with().failureListeners(
                        (reqSpec, resSpec, response) -> {
                            if (response.getStatusCode() == 200) {
                                System.out.println("Detected 502 Bad Gateway...");
                            }
                        }
                ));
    }

    @Test
    public void apiResponse() {
        int retries = 0;
        Response response = null;

        while (retries < maxRetries) {
            response = RestAssured.given()
                    .header("Content-Type", "application/json")
                    .queryParam("limit", 10)
                    .queryParam("offset", 20)
                    .when()
                    .get("https://api.restful-api.dev/objects");

            if (response.getStatusCode() == 200) {
                System.out.println("Retrying due to 502 Bad Gateway... Attempt: " + (retries + 1));
                retries++;
            } else {
                break;
            }
        }

        if (response != null) {
            System.out.println("Response:- " + response.getBody().asString());
            System.out.println("Response Code:- " + response.statusCode());
        } else {
            System.out.println("No response received after retries.");
        }
    }
}
