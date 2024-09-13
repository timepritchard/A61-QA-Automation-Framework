package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.reporters.jq.BasePanel.I;

public class NewPlaylistDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;

    /*@Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--start-maximized");
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

    }*/
    @After
    public void closeBrowser(){
        driver.quit();
    }
    @When("I tap to create a new playlist")
    public void createNewPlaylist(){
        homePage.plusBtnPlaylist();
    }
    @And("I select new playlist")
    public void iSelectNewPlaylist() {
        homePage.addNewPlaylist();
    }

    @And("I type {string}")
    public void iType(String inputNewPlaylistName) {
        homePage.typeNewName(inputNewPlaylistName);
    }

    @Then("I see the new playlist notification")
    public void iSeeTheNewPlaylistNotification() {
        Assert.assertTrue(homePage.playlistNotification());
    }
}
