package test.codingPart.seleniumQues;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BiDi_CDP {

    ChromeDriver driver;


    @AfterTest
    public void tearDown() {
        driver.close();
    }


    @Test
    public void bidi() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("webSocketUrl", true);
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");

        // Add a listener for log events
        driver.script().addConsoleMessageHandler((logEntry) -> {
            System.out.println(logEntry.toString());
        });

        // Trigger a console log on the demo page
        driver.findElement(By.id("consoleLog")).click();

        driver.quit();
    }
}
