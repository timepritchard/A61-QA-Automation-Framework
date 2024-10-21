import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

    @Test
    public void renamePlaylist() {
        String expectedMessage = "Updated playlist \"Sample Edited Playlist.\"";
        // Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        // Tests

        loginPage.provideEmail("timothy.pritchard@testpro.io");
        loginPage.providePassword("q9RQ8fbN");
        loginPage.clickSubmit();
        homePage.selectPlaylist();
        homePage.clearPlaylist();
        homePage.inputNewName();

        //Assert
        Assert.assertEquals(homePage.notificationText(), expectedMessage);
    }
}