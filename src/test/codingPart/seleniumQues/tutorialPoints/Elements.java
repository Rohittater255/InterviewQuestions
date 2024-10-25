package codingPart.seleniumQues.tutorialPoints;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Elements {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test(enabled = false)
    public void textBox() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");


        driver.findElement(By.id("fullname")).sendKeys("Rohit");
        driver.findElement(By.id("email")).sendKeys("Rohit@gmail.com");
        driver.findElement(By.id("address")).sendKeys("address");
        driver.findElement(By.id("password")).sendKeys("password");
        //  driver.findElement(By.xpath("//*[@type='submit']")).submit();
        driver.findElement(By.xpath("//*[@type='submit']")).click();

    }

    @Test
    public void tooltip() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/tool-tips.php");

        //Instantiate Action Class
        Actions actions = new Actions(driver);

        // Find the age field
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'on top')]"))).build().perform();

        //get the value of the "title" attribute
        String actualTooltip = driver.findElement(By.xpath("//*[contains(text(),'on top')]")).getAttribute("title");
        System.out.println("Tool Tip:- " + actualTooltip);

    }

    @Test(enabled = false)
    public void radioButton() {
        //navigate to webpage
        driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");


        Assert.assertFalse(driver.findElement(By.xpath("//*[@value='igottwo']")).isSelected());
        driver.findElement(By.xpath("//*[@value='igottwo']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='igottwo']")).isSelected());

        Assert.assertFalse(driver.findElement(By.xpath("//*[@value='igotthree']")).isSelected());
        driver.findElement(By.xpath("//*[@value='igotthree']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='igotthree']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@value='igottwo']")).isSelected());

    }
}
