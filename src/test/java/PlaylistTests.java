import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.PlaylistPageFactory;
import pages.LoginPage;

public class PlaylistTests extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletePlaylistNotification = "Deleted playlist";

        // create objects
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePageFactory homepageFactory = new HomePageFactory(driver);
        PlaylistPageFactory playlistPageFactory = new PlaylistPageFactory(driver);

        //Steps
        loginPageFactory.provideEmail("timothy.pritchard@testpro.io");
        loginPageFactory.providePassword("q9RQ8fbN");
        loginPageFactory.clickSubmitBtn();
        homepageFactory.clickPlaylist();
        playlistPageFactory.deleteSelectedPlaylist();
        Assert.assertEquals(playlistPageFactory.getPlaylistNotification(), expectedDeletePlaylistNotification);

    }
}