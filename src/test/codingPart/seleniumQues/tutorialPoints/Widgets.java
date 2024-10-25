package codingPart.seleniumQues.tutorialPoints;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Widgets {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() throws IOException {
        driver.close();
        Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
    }


    @Test(enabled = false)
    public void datePicker() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");

        driver.findElement(By.id("datetimepicker1")).click();

        String date = "January 1, 2023";
        String month = date.split(" ")[0];
        String year = date.split(" ")[2];

        //Click on Date selector
        Select select = new Select(driver.findElement(By.xpath("//div[@class='flatpickr-calendar hasTime animate open arrowTop arrowLeft']//select[@class='flatpickr-monthDropdown-months']")));

        //Wait for date popup to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flatpickr-calendar hasTime animate arrowTop arrowLeft open']//input[@aria-label='Year']/following-sibling::span[@class='arrowUp']")));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='flatpickr-calendar hasTime animate arrowTop arrowLeft open']//input[@aria-label='Year']/following-sibling::span[@class='arrowUp']"))).build().perform();
        //Select Year
        for (int i = 0; i < 2024 - 2023; i++) {
            driver.findElement(By.xpath("//div[@class='flatpickr-calendar hasTime animate arrowTop arrowLeft open']//input[@aria-label='Year']/following-sibling::span[@class='arrowUp']")).click();
        }

        select.selectByVisibleText(month);

        driver.findElement(By.xpath("//div[@class='dayContainer']/span[@class='flatpickr-day' and @aria-label='October 1, 2024']")).click();
    }


    @Test()
    public void slider() throws InterruptedException {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");

        //Perform click
        WebElement slider = driver.findElement(By.id("ageInputId"));
        slider.click();

        //Perform Movde in Slider
        int moveToAge = 45;//55
        while (Integer.valueOf(driver.findElement(By.id("ageOutputId")).getText()) != moveToAge) {
            if (moveToAge > 50) {
                slider.sendKeys(Keys.ARROW_RIGHT);
            } else {
                slider.sendKeys(Keys.LEFT);
            }
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Moved to " + driver.findElement(By.id("ageOutputId")).getText());
        }
    }

    @Test(enabled = false)
    public void progressBar() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/progress-bar.php");

        //Perform click
        driver.findElement(By.id("startProgressTimer")).click();

        //Assert  action is performed
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(10))
                .withTimeout(Duration.ofSeconds(100))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='progress-bar progress-bar-success']")));

    }

}
