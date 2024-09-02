import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class LoginTests extends BaseTest {
   /* @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }*/
    @Test
    public void positiveLoginTest(){
        //Objects
        LoginPage loginPage = new LoginPage(getDriver());
        LoginPageFactory loginPageFactory = new LoginPageFactory(getDriver());
        HomePage homePage = new HomePage(getDriver());
        HomePageFactory homePageFactory = new HomePageFactory(getDriver());
        //Steps
        loginPage.provideEmail("timothy.pritchard@testpro.io");
        loginPage.providePassword("q9RQ8fbN");
        loginPage.clickSubmit();
        //Expected versus Actual
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}
