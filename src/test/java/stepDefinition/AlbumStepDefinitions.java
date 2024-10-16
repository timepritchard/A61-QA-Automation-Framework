package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AlbumsPage;
import pages.HomePage;
import pages.LoginPage;

public class AlbumStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AlbumsPage albumsPage;

    @Before
    public void setUp() {
        driver = WebDriverManager.getDriver();  // Initialize WebDriver from WebDriverManager
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        albumsPage = new AlbumsPage(driver);
    }
    @After
    public void tearDown() {
        WebDriverManager.closeDriver();
    }
    @And("I tap Albums")
    public void iTapAlbums(){
        homePage.albumsList();
    }

    @Then("all of them have cover photos")
    public void allOfThemHaveCoverPhotos() {
        Assert.assertTrue(albumsPage.doAllAlbumsHaveCovers());

    }

    @Then("all of them should have an album name")
    public void allOfThemShouldHaveAnAlbumName() {
        Assert.assertTrue(albumsPage.doAllAlbumsHaveNames());
    }

    @And("I open album {string}")
    public void iOpenAlbum(String album) {
        albumsPage.tapOnAlbum(album);

    }
    @Then("I check the songs in the album are displayed")
    public void iCheckTheSongsInTheAlbumAreDisplayed() {
        Assert.assertTrue(albumsPage.areSongsDisplayed());
    }

    @And("the correct number of songs are displayed")
    public void theCorrectNumberOfSongsAreDisplayed() {
        Assert.assertEquals(albumsPage.howManySongsInList(), albumsPage.numberOfSongsInHeader());
    }

    @Then("the shuffle icon should be shown")
    public void theShuffleIconShouldBeShown() {
        Assert.assertTrue(albumsPage.shuffleIconShown().isDisplayed());

    }

    @Then("download all button should be shown")
    public void downloadAllButtonShouldBeShown() {
        Assert.assertTrue(albumsPage.downloadBtnShown().isDisplayed());
    }

    @And("I refresh browser")
    public void iRefreshBrowser() {
        driver.navigate().refresh();
        try {
            Thread.sleep(3000); // Sleep for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
