package codingPart.seleniumQues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BiDi_CDP {

    ChromeDriver driver;


    @AfterTest
    public void tearDown() {
        driver.close();
    }


    @Test
    public void bidi(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        driver = new ChromeDriver();
        driver.get("https://whatismytimezone.com/");

        System.out.println("Session: "+ driver.getBiDi().getBidiSessionStatus().getMessage());
        System.out.println("Session: "+ driver.getBiDi().getBidiSessionStatus().getMessage());
    }
}
