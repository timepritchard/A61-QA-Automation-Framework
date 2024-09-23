package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class NewPlaylistDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;

    @Before
        public void setUp() {
            driver = WebDriverManager.getDriver();  // Initialize WebDriver from WebDriverManager
            loginPage = new LoginPage(driver);      // Initialize page objects after driver is ready
            homePage = new HomePage(driver);

    }
    @After
    public void tearDown() {
        WebDriverManager.closeDriver();  // Ensures driver is properly closed after tests
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

    @Then("I should not see the new playlist notification")
    public void iShouldNotSeeTheNewPlaylistNotification() {
        Assert.assertFalse(homePage.playlistNotification());
    }
}
