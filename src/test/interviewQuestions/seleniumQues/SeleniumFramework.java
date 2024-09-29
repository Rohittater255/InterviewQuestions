package test.interviewQuestions.seleniumQues;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumFramework {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void a() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");//handle notification
        options.addArguments("--ignore-certificate-errors");//handle SSl
        options.setAcceptInsecureCerts(true);//handle SSl
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
//        options.setCapability();
//        Path path = Paths.get("src/test/interviewQuestions/rohit.crx");
//        File extensionFilePath = new File(path.toUri());
//        options.addExtensions(extensionFilePath);
        driver = new ChromeDriver(options);

        //Remote:
//        DesiredCapabilities capabilities = new DesiredCapabilities();//Depricated in selenium 4

        RemoteWebDriver driver = new RemoteWebDriver(new URL(""), options);
    }

    @AfterTest(alwaysRun = true)
    public void b() {
        //closes
        driver.close();

        //quit
        driver.quit();
    }

    @Test
    public void rt() throws  InterruptedException {

        //navigate to webpage
        driver.get("https://www.amazon.in/");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        for (LogEntry entry : driver.manage().logs().get(LogType.BROWSER)) {
            String msg = entry.getMessage();
            System.err.println("Message: " + msg);
        }
        System.out.println("Cookies: " + driver.manage().getCookies());
        System.out.println("Size: " + driver.manage().window().getSize());
        System.out.println("height: " + driver.manage().window().getSize().height);
        System.out.println("width: " + driver.manage().window().getSize().width);

        //window minimize/maximize
//        driver.manage().window().minimize();
//        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Check text Enabled: " + driver.findElement(By.xpath("//a[text()='Amazon miniTV']")).isEnabled());
        System.out.println("Check text Displayed: " + driver.findElement(By.xpath("//a[text()='Amazon miniTV']")).isDisplayed());
        System.out.println("Check text Selected: " + driver.findElement(By.xpath("//a[text()='Amazon miniTV']")).isSelected());

//        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        explicitWait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//a[text()='Amazon miniTV']"))));

        //Check Broken Links
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));
        for (int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getText();
            String href = elements.get(i).getAttribute("href");
            System.out.println("Text: " + text + "Href: " + href);
            RestAssured.useRelaxedHTTPSValidation();

            Response response = RestAssured.given().when().get(href);
            int code = response.statusCode();
            if (code == 200) {
                System.out.println("Href: " + href + " code " + code);
                System.out.println("Success");
            } else {
                System.out.println("Href: " + href + " code " + code);
                System.out.println("Failure");
            }
        }


        //navigate to webpage
        driver.navigate().to("https://stackoverflow.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();


        //Frames
        driver.get("https://omayo.blogspot.com/");
        List<WebElement> list = driver.findElements(By.xpath("//iframe"));
        System.out.println("The Number of frames " + list.size());

        driver.switchTo().frame("iframe1");
        driver.findElement(By.xpath("//a[text()='What is Selenium?']")).click();
        driver.switchTo().defaultContent();
        System.out.println("The Number of frames " + list.size());

        List<WebElement> a = driver.findElements(By.xpath("//h2[text()='UnOrdered list']/following-sibling::div/ul/li"));
        for (int i = 0; i < a.size(); i++) {
            System.out.println("Text " + a.get(i).getText());
        }

        driver.findElement(By.id("alert2")).click();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Text in Alert " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("chrome://downloads/");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.querySelector('downloads-manager').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput').click();");
        js.executeScript("document.querySelector('downloads-manager').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput').value='Rohit'");
TimeUnit.SECONDS.sleep(10);

        //        //Declare and initialise a fluent wait
//        FluentWait fluentWait = new FluentWait(driver);
//        fluentWait.withTimeout(Duration.ofSeconds(10));
//        fluentWait.pollingEvery(Duration.ofSeconds(101));
//        fluentWait.ignoring(NoSuchElementException.class);
//        fluentWait.until(ExpectedConditions.alertIsPresent());

    }
}
