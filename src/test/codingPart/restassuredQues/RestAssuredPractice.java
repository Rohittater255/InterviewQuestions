package codingPart.restassuredQues;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class RestAssuredPractice {

    @Test
    public void enableSSL() {
        //Disable SSL
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void disableSSL() {
        //Enable SSL
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

    }

    @Test
    public void runGetAndDownloadFile() {
        String url = "https://mozilla.github.io/pdf.js/web/viewer.html"; // Replace with your actual URL
        Response response = RestAssured.given().when().get(url);

        try (InputStream inputStream = response.asInputStream();
             FileOutputStream outputStream = new FileOutputStream("downloaded_file")) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer);
            }
            System.out.println("File downloaded successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runGetRequestWithParameter() {
        //Run Get
        Response response = RestAssured.given().header("Content-Type", "application/json").
                //pathParam("", "").
                        queryParam("limit", 10).  // Set the limit
                        queryParam("offset", 20). // Set the offset
                        when().
                get("https://api.restful-api.dev/objects");
        System.out.println("Response:- " + response.getBody().asString());
        System.out.println("Response Code:- " + response.statusCode());
    }

    @Test
    public void jsonObject() throws JSONException {
//        {
//            "name": "Rohit",
//                "contact": [
//            {
//                "number": "1234567890",
//            },
//            {
//                "number": "0987654321",
//            }
//            ]
//        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Rohit");

        JSONArray arr = new JSONArray();
        JSONObject contact1 = new JSONObject();
        contact1.put("number", "1234567890");
        arr.put(contact1);

        JSONObject contact2 = new JSONObject();
        contact2.put("number", "0987654321");
        arr.put(contact2);

        jsonObject.put("contact", arr);

        System.out.println(jsonObject);
        String contact = JsonPath.using(Configuration.defaultConfiguration()).parse(jsonObject.toString()).read("$.name");
        System.out.println(contact);
    }

}
