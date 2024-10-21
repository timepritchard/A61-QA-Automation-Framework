import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class AllSongsTest extends BaseTest {
    @Test
    public void playSongWithContextClick() {
        // Objects
        AllSongsPage allSongsPage = new AllSongsPage(driver);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);

        loginPage.provideEmail("timothy.pritchard@testpro.io");
        loginPage.providePassword("q9RQ8fbN");
        loginPage.clickSubmit();
        homePage.allSongs();
        allSongsPage.contextClickFirstSong();
        allSongsPage.tapPlay();
        Assert.assertTrue(basePage.isSoundBarDisplayed());
    }
}