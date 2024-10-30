package codingPart.seleniumQues.tutorialPoints;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Interactions {

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
    public void selectable() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/selectable.php");

        driver.findElement(By.xpath("//li[text()='It is a long established fact that a reader will be distracted']")).click();

        //Verify action is performed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='It is a long established fact that a reader will be distracted' and contains(@class,'active')]")));

        driver.findElement(By.id("nav-profile-tab")).click();
        driver.findElement(By.xpath("//li[text()='1']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='1' and contains(@class,'active')]")));
    }

    @Test()
    public void resizeable() {
        //navigate to webpage
        //driver.get("https://www.tutorialspoint.com/selenium/practice/resizable.php");
//        WebElement e = driver.findElement(By.xpath("//div[@class='both selector']"));
//        System.out.println("text:- " +e.getText());

        driver.get("https://jqueryui.com/resizable/");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement e = driver.findElement(By.xpath("//*[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
//        System.out.println("text:- " +e.getText());

        //Getting Attribute Before Performing action
        System.out.println("width Before: " + e.getCssValue("width"));
        System.out.println("height Before: " + e.getCssValue("height"));

        //Perform Operation
        Actions action = new Actions(driver);
        action.dragAndDropBy(e, 204, 104).build().perform();

        //Getting Attribute Before Performing action
        System.out.println("width After: " + e.getCssValue("width"));
        System.out.println("height After: " + e.getCssValue("height"));
    }

    @Test(enabled = false)
    public void droppable_dragAndDrop() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/droppable.php");

        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Drop here']")).isDisplayed());

        //Perform Operation
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();

        //Verify action is performed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Dropped!']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Dropped!']")).isDisplayed());
    }

    @Test(enabled = false)
    public void draggable() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");

        //Getting Attribute Before Performing action
        System.out.println("Left Before: " + driver.findElement(By.id("draggables")).getCssValue("left"));
        System.out.println("Top Before: " + driver.findElement(By.id("draggables")).getCssValue("top"));

        //Perform action
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(By.id("draggables")), 200, 150).build().perform();

        //Getting Attribute Before Performing action
        System.out.println("Left After: " + driver.findElement(By.id("draggables")).getCssValue("left"));
        System.out.println("Top After: " + driver.findElement(By.id("draggables")).getCssValue("top"));

    }


    @Test(enabled = false)
    public void copyPasteFromKeyBoard() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();

        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/dragabble.php");

        Actions action = new Actions(driver);


        action.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().build().perform();
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Motorola Edge 50 Fusion 5G (Hot Pink, 12GB RAM, 256GB Storage)");
        action.moveToElement(driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"))).click().build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-component-type='s-search-results']//span[contains(text(),'Motorola Edge 50 Fusion 5G (Hot Pink, 12GB RAM, 256GB Storage)')]/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row']//span[@class='a-price-whole']")));
        String text = driver.findElement(By.xpath("//span[@data-component-type='s-search-results']//span[contains(text(),'Motorola Edge 50 Fusion 5G (Hot Pink, 12GB RAM, 256GB Storage)')]/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row']//span[@class='a-price-whole']")).getText();
        System.out.println("text: " + text);

        //Right Click
        action.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).contextClick().build().perform();

        // Perform keyboard actions
        //Ctrl+A
        action.keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();

        //Ctrl+C
        action.keyDown(Keys.CONTROL).sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();

        //Ctrl+V
        action.keyDown(Keys.CONTROL).sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
        TimeUnit.SECONDS.sleep(10);
    }

}
