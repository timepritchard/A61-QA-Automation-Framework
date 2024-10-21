package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

import static org.testng.Assert.assertTrue;

public class ArtistsStepDefinition {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ArtistsPage artistsPage;
    SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();  // Initialize WebDriver from WebDriverManager
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        artistsPage = new ArtistsPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @After
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
    @When("I tap Artists")
    public void iTapArtists() {
        homePage.tapArtists();
    }

    @Then("I see all artists in the list")
    public void iSeeAllArtistsInTheList() {
        assertTrue(artistsPage.songsShown().isDisplayed());
        }

    @When("I tap on the search bar and search artist {string}")
    public void iTapOnTheSearchBarNdSearchArtist(String artistName) {
        homePage.searchArtist(artistName);
    }

    @Then("I see songs from this artist")
    public void iSeeSongsFromThisArtist() {
        assertTrue(searchResultsPage.songsByArtist());
    }

    @And("I check that it is a song by the artist searched for {string}")
    public void iCheckThatItIsASongByTheArtistSearchedFor(String artistName) {
        String actualArtist = searchResultsPage.checkArtistsName(artistName);
        Assert.assertTrue(actualArtist.contains(artistName));

    }
    @And("I tap play on the song")
    public void iTapPlayOnTheSong() {
        searchResultsPage.playSearchedSong();
    }
    @Then("the song starts to play")
    public void theSongStartsToPlay() {
        Assert.assertTrue(searchResultsPage.songPlaying());
    }
}