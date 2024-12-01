package test.codingPart.seleniumQues;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class UploadAndDownloadFile {


    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test()
    public void downloadFile2() {


        ChromeOptions options = new ChromeOptions();
        //Enable Downloads
        options.setEnableDownloads(true);
        // Set download directory
        String downloadFilePath = "C:\\Automation\\InterviewQuestions";
        options.addArguments("download.default_directory=" + downloadFilePath);

        ChromeDriver driver1 = new ChromeDriver(options);

        // Enable downloads using DevTools Protocol
        DevTools devTools = driver1.getDevTools();
        devTools.createSession();
//        devTools.send(Browser.setDownloadBehavior(Browser.SetDownloadBehaviorBehavior.ALLOW, Optional.of(downloadFilePath)));

        driver1.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");
        List<String> l= driver1.getDownloadableFiles();
        System.out.println("getDownloadableFiles"+l.size());
    }

    //Refer https://www.youtube.com/watch?v=Qb3EZYGnono
    @Test(enabled = false)
    public void downloadFile() {
        driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");

        String downloadPath = "C:\\Users\\";
        String fileName = "jenkins.msi";

        File file = new File(downloadPath, fileName);

        FluentWait<File> wait = new FluentWait<>(file)
                .withTimeout(Duration.ofMinutes(5))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class).withMessage("file is not downloaded");
        try {
            boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());
            if (isDownloaded) {
                System.out.println("file is completely 100% downloaded");
            }
        } catch (TimeoutException e) {
            System.out.println("file is not completely  downloaded");
        }
    }

    @Test(enabled = false)
    public void uploadFile() {
        driver.get("https://practice.expandtesting.com/upload");
        //Click choose file
        driver.findElement(By.xpath("//input[@id='fileInput']")).sendKeys("C:\\Automation\\InterviewQuestions\\pom.xml");

        //click upload
        driver.findElement(By.xpath("//button[@id='fileSubmit']")).click();
    }
}
