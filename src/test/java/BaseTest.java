import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    WebDriverWait wait;
    Actions actions;

    @BeforeSuite
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    //static void setupClass(){
        //WebDriverManager.firefoxdriver().setup();
    //}
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications","--remote-allow-origins=*", "--incognito","--start-maximized");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-search-engine-choice-screen");


        //driver = new ChromeDriver(options);
        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.get(BaseURL);
    }
@AfterMethod
    public void closeBrowser(){
        driver.quit();

}

    public void submitLogin() {
        //WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    public void inputPassword(String password) {
        //WebElement passField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("input[type='password']")));
        passField.clear();
        passField.sendKeys(password);
    }

    public void inputEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static WebDriver pickBrowser(String browserName) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        String gridUrl = "http://192.168.5.73:4444/";

        switch (browserName){
           case "firefox":
               WebDriverManager.firefoxdriver().setup();
               return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions. addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            // Grid related Browsers
            case "grid-edge":
                caps.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridUrl).toURL(),caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);

       }
    }
   /* no longer needed: public void navigateToPage() {
        //String url = "https://qa.koel.app/";
        driver.get(url);
    } */
}
