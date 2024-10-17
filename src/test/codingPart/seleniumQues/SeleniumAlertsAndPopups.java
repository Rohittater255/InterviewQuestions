package codingPart.seleniumQues;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumAlertsAndPopups {


    //Refer https://www.youtube.com/watch?v=fGAggGbvtw4
    @Test(enabled = false)
    public void handleAlertWithAuth() {
        WebDriver driver = new ChromeDriver();
        String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";//"https://the-internet.herokuapp.com/basic_auth";
        driver.get(url);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Congratulations! You must have the proper credentials')]")).isDisplayed());
        driver.close();
    }

    @Test
    public void sendTextInAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='promtButton']"))));
//        driver.findElement(By.xpath("//*[@id='promtButton']")).click();
// Wait for the button to be clickable
        WebElement promptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("promtButton")));


        // Scroll to the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", promptButton);

        // Click the button using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", promptButton);
        System.out.println("Text " + driver.switchTo().alert().getText());
        // Switch to alert and interact with it
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        //jsExecutor.executeScript("window.promptResponse = window.prompt('Text Please enter your name', '');");
        jsExecutor.executeScript("window.promptResponse = 'Rohit';");

        //
        TimeUnit.MINUTES.sleep(10);
        driver.close();
    }
}
