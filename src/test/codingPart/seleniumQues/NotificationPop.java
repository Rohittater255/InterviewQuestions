package codingPart.seleniumQues;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NotificationPop {

    WebDriver driver;

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test( )
    public void textBox() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");//handle notification
        driver = new ChromeDriver();
        //navigate to webpage
        driver.get("https://whatmylocation.com/");
        driver.manage().window().maximize();
        TimeUnit.SECONDS.sleep(100);
    }

}
