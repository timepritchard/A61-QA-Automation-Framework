package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager { // Renamed to avoid confusion with the imported WebDriverManager
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup(); // Use WebDriverManager's setup method
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
            options.addArguments("--disable-search-engine-choice-screen");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

