import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PlaylistPage;

public class PlaylistTests extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletePlaylistNotification = "Deleted playlist";

        // create objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);

        //Steps
        loginPage.provideEmail("timothy.pritchard@testpro.io");
        loginPage.providePassword("q9RQ8fbN");
        loginPage.clickSubmit();
        homepage.clickPlaylist();
        playlistPage.deleteSelectedPlaylist();
        Assert.assertEquals(playlistPage.getPlaylistNotification(), expectedDeletePlaylistNotification);
    }
    @Test
    public void addSongToPlaylist(){
        String nameOfPlaylist = "Tim";
        String expectedSongAddedMessage = "Added 1 song into \"" + nameOfPlaylist + ".\"";
        // create objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homepage = new HomePage(driver);
        PlaylistPage playlistPage = new PlaylistPage(driver);
        //Steps
        loginPage.provideEmail("timothy.pritchard@testpro.io");
        loginPage.providePassword("q9RQ8fbN");
        loginPage.clickSubmit();
        homepage.songSearch("beach");
        homepage.clickAll();
        homepage.firstSong();
        homepage.addToButton();
        homepage.addToPlaylist("Tim");
        Assert.assertEquals(homepage.notificationText(), expectedSongAddedMessage);

    }
}