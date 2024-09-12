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
import pages.CurrentQueuePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static org.testng.reporters.jq.BasePanel.I;

public class TopOfQueueDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    CurrentQueuePage currentQueuePage;
    String storedSongName;
    String firstSongName;

    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications", "--remote-allow-origins=*", "--incognito", "--start-maximized");
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        currentQueuePage = new CurrentQueuePage(driver);
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

    @When("I tap current queue")
    public void currentQueue(){
        homePage.tapCurrentQueue();
    }
    @And("I select the 10th song")
    public void iSelectTheThSong() {
        currentQueuePage.selectTenthSong();
    }
    @And("I check its name")
    public void iCheckItsName() {
        storedSongName = currentQueuePage.tenthSongName();
    }
    @And("I tap 'add to")
    public void iTapAddTo() {
        currentQueuePage.clickAddToBtn();
    }
    @And("I select top of queue")
    public void iSelectTopOfQueue() {
        currentQueuePage.topOfQueue();
    }
    @And("I check the new song is at the top of the queue")
    public void iCheckTheNewSongIsAtTheTopOfTheQueue() {
        firstSongName = currentQueuePage.firstSongName();
    }
    @Then("the song is placed at the top of the queue")
    public void theSongIsPlacedAtTheTopOfTheQueue() {
        System.out.println("Stored Song Name: " + storedSongName);
        System.out.println("First Song Name: " + firstSongName);
        Assert.assertEquals(firstSongName, storedSongName);
    }
}