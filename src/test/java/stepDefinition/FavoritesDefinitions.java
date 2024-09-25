package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AllSongsPage;
import pages.FavoritesPage;
import pages.HomePage;
import pages.LoginPage;

public class FavoritesDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    AllSongsPage allSongsPage;
    FavoritesPage favoritesPage;
    private String firstSongTitle;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();  // Initialize WebDriver from WebDriverManager
        loginPage = new LoginPage(driver);      // Initialize page objects after driver is ready
        homePage = new HomePage(driver);
        allSongsPage = new AllSongsPage(driver);
        favoritesPage = new FavoritesPage(driver);

    }
    @After
    public void tearDown() {
        WebDriverManager.closeDriver();  // Ensures driver is properly closed after tests
    }
    @When("I tap home")
    public void iTapHome() {
        homePage.homePageTab();
        try {
            Thread.sleep(3000); // Sleep for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @And("I tap All songs")
    public void iTapAllSongs(){
        homePage.allSongs();
    }

    @And("I favorite song {string}")
    public void iFavoriteSong(String song) {
        allSongsPage.favoriteSong(song);
    }

    @And("I tap favorites")
    public void iTapFavorites() {
        homePage.favoriteList();
    }

    @Then("I see the song in the favorite list")
    public void iSeeTheSongInTheFavoriteList() {
        String song = "Pluto";
        boolean newFavAdded = favoritesPage.newFavoriteAdded(song);
        Assert.assertTrue(newFavAdded);
    }

    @Then("the song is removed from the favorite list")
    public void theSongIsRemovedFromTheFavoriteList() {
        String song = "Pluto";
        boolean newFavAdded = favoritesPage.newFavoriteAdded(song);
        Assert.assertFalse(newFavAdded);
    }

    @And("I remove favorite {string}")
    public void iRemoveFavorite(String favorite) {
        favoritesPage.removeFavorite(favorite);
    }

    @Then("I see no favorites yet")
    public void iSeeNoFavoritesYet() {
        Assert.assertTrue(favoritesPage.noFavoritesYet().isDisplayed());
    }
}
