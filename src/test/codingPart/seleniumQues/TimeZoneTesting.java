package codingPart.seleniumQues;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class TimeZoneTesting {

    @Test(description = "https://www.linkedin.com/posts/sriramku_time-zone-testing-automating-across-time-activity-7255920474633732096-OVrm/")
    public void timeZoneTest1() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();

        // Set the timezone using executeCdpCommand
        Map<String, Object> params = new HashMap<>();
        params.put("timezoneId", "Asia/Singapore");
        driver.executeCdpCommand("Emulation.setTimezoneOverride", params);

        // Navigate to a website to verify timezone
        driver.get("https://whatismytimezone.com/");
        System.out.println(driver.findElement(By.tagName("article")).getText());


        driver.close();
    }


}
