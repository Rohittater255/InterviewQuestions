package codingPart.seleniumQues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DispappearingElements {

    //https://www.youtube.com/watch?v=NdGjlSa3hSo
    //setTimeout(()=>{debugger;},1000)
    @Test
    public void handleDisappearingElement() throws InterruptedException {
        WebDriver driver= new ChromeDriver();

        //Navigate to Flipkart
        driver.get("https://www.flipkart.com/");

        //Search Samsung
        driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Samsung");

        TimeUnit.SECONDS.sleep(10);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@action='/search']//span/parent::div"))));

        //Get List of Elements shown in dropdown
        List<WebElement> el= driver.findElements(By.xpath("//form[@action='/search']//span"));
        for (int i = 0; i < el.size() ; i++) {
            System.out.println("el"+el.get(i).getText());
        }

        driver.close();
    }
}
