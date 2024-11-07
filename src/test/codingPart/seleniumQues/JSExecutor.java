package codingPart.seleniumQues;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JSExecutor {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }


    @Test
    public void scroldown() throws InterruptedException {
        driver.get("https://www.google.com/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)"); // Scroll down by 1000 pixels Thread.sleep(3000); // Pause to see the scroll effect
    }

    @Test
    public void scrollup() throws InterruptedException {
        driver.get("https://www.google.com/");
        // Scroll back up by 1000 pixels
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(3000);}

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        //closes
        driver.close();

        //quit
        driver.quit();
    }

}
