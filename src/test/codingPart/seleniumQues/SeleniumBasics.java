package codingPart.seleniumQues;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class SeleniumBasics {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");//handle notification
        options.addArguments("--ignore-certificate-errors");//handle SSl
        options.setAcceptInsecureCerts(true);//handle SSl
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
        options.addArguments("--safebrowsing-disable-download-protection");

        options.addArguments("--unsafely-treat-insecure-origin-as-secure=" + "https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--disable-features=InsecureDownloadWarnings");//To allow downloads
//        options.setCapability();
//        Path path = Paths.get("src/test/interviewQuestions/rohit.crx");
//        File extensionFilePath = new File(path.toUri());
//        options.addExtensions(extensionFilePath);
        driver = new ChromeDriver(options);

        //Remote:
//        DesiredCapabilities capabilities = new DesiredCapabilities();//Depricated in selenium 4
//        RemoteWebDriver driver = new RemoteWebDriver(new URL(""), options);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        //closes
        driver.close();

        //quit
        driver.quit();
    }


    @Test(enabled = false)
    public void openBrowserAndPerformBasicOperations() throws InterruptedException, IOException {
        //Get URL
        driver.get("https://www.amazon.in/");


        //Print Title and URL
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        //Print driver logs
        for (LogEntry entry : driver.manage().logs().get(LogType.BROWSER)) {
            String msg = entry.getMessage();
            System.err.println("Message: " + msg);
        }

        //Print Cookies/Size etc
        System.out.println("Cookies: " + driver.manage().getCookies());
        System.out.println("Size: " + driver.manage().window().getSize());
        System.out.println("height: " + driver.manage().window().getSize().height);
        System.out.println("width: " + driver.manage().window().getSize().width);

        //window minimize/maximize
        driver.manage().window().minimize();
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();

        System.out.println("Check text Enabled: " + driver.findElement(By.xpath("//a[text()='Mobiles']")).isEnabled());
        System.out.println("Check text Displayed: " + driver.findElement(By.xpath("//a[text()='Mobiles']")).isDisplayed());
        System.out.println("Check text Selected: " + driver.findElement(By.xpath("//a[text()='Mobiles']")).isSelected());


        //navigate to webpage
        driver.navigate().to("https://stackoverflow.com/");
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("URL: " + driver.getCurrentUrl());
        driver.navigate().refresh();
        System.out.println("URL: " + driver.getCurrentUrl());
    }

    @Test(enabled = false)
    public void openBrowserAndHandleWais() {
        //navigate to webpage
        driver.get("https://www.amazon.in/");


        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Explicit Wait
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        explicitWait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//a[text()='Amazon miniTV']"))));

        //Declare and initialise a fluent wait
        FluentWait fluentWait = new FluentWait(driver);
        fluentWait.withTimeout(Duration.ofSeconds(100));
        fluentWait.pollingEvery(Duration.ofSeconds(10));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.alertIsPresent());
    }

    @Test(enabled = false)
    public void openBrowserAndCheckBrokenLinks() throws InterruptedException, IOException {

        //navigate to webpage
        driver.get("https://www.amazon.in/");


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

    }

    @Test(enabled = false)
    public void openBrowserAndHandleFrames() throws InterruptedException, IOException {

        //navigate to webpage
        driver.get("https://omayo.blogspot.com/");

        //Get Frames Count
        List<WebElement> list = driver.findElements(By.xpath("//iframe"));
        System.out.println("The Number of frames " + list.size());

        //Switch to specific frame, click on element and go back to orignal frame
        driver.switchTo().frame("iframe1");
        driver.findElement(By.xpath("//a[text()='What is Selenium?']")).click();
        driver.switchTo().defaultContent();
        System.out.println("The Number of frames " + list.size());

        List<WebElement> a = driver.findElements(By.xpath("//h2[text()='UnOrdered list']/following-sibling::div/ul/li"));
        for (int i = 0; i < a.size(); i++) {
            System.out.println("Text " + a.get(i).getText());
        }
    }

    @Test(enabled = false)
    public void openBrowserAndHandleAlerts() throws InterruptedException, IOException {

        //navigate to webpage
        driver.get("https://omayo.blogspot.com/");

        //Handle Alerts
        driver.findElement(By.id("alert2")).click();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Text in Alert " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //Take Screenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot Created at local Folder path:- " + scrFile);
        String screenshotDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();
        File destFile = new File(screenshotDirectory + "//" + "Rohit_" + System.currentTimeMillis() + "_" + ".png");
        // Move the screenshot file to the destination
        Files.move(scrFile.toPath(), destFile.toPath());
        System.out.println("Screenshot saved to: " + destFile.getAbsolutePath());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("chrome://downloads/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('downloads-manager').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput').click();");
        js.executeScript("document.querySelector('downloads-manager').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput').value='Rohit'");
        TimeUnit.SECONDS.sleep(10);


    }



}
