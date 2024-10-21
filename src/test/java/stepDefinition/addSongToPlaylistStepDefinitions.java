package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

public class addSongToPlaylistStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AllSongsPage allSongsPage;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();  // Initialize WebDriver from WebDriverManager
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        allSongsPage = new AllSongsPage(driver);
    }
    @After
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
    @And("I tap on song {string}")
    public void iTapOnASong(String song){
        allSongsPage.tapSong(song);

    }
    @And("I tap add to")
    public void iTapAddTo() {
        allSongsPage.tapAddTo();
    }

    @And("I select playlist {string}")
    public void iSelectPlaylist(String playList) {
        allSongsPage.tapPlaylist(playList);
    }

    @Then("I check the song is shown in the correct playlist {string}")
    public void iCheckTheSongIsShownInTheCorrectPlaylist(String playList) {
        Assert.assertTrue(allSongsPage.notificationBoxShown(playList));

    }
}
