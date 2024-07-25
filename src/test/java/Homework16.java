import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {
    @Test
    public void registrationNavigation() {
        WebDriver driver = new ChromeDriver();
        // Using selenium, navigate to "https://qa.koel.app/"
    String homeUrl = "https://qa.koel.app/";
    driver.get(homeUrl);
// Click the Registration link
    WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
    registrationLink.click();
    // Add a pause
        // commenting out because this doesn't work:
        // Thread.sleep(2000);
        // Verify that you are redirected to Registration page using Assert method
        String registrationUrl = "https://qa.koel.app/registration";
       String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, registrationUrl);
        // quit driver
        driver.quit();

// I have some questions!
        // should I have started with public static void main(String[] args) ? If so when do I start with this and when don't I?
        // What is the 'throws InterruptedException' in the class demos?
        // When do I start with: ChromeOptions options = new ChromeOptions();
        //                      options.addArguments("--remote-allow-origins");
        // What does @Test do?
        // Why didn't my sleep work?
        // Why didn't the test work?!


    }
}
