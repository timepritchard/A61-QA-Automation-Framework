import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


public class Homework17 extends BaseTest {
   @Test
   public void addSongToPlaylist() throws InterruptedException {
       String playlistName = "Tim";
       String expectedSongAddedMessage = "Added 1 song into \"" + playlistName + ".\"";
       navigateToPage();
       // 5. Login with your credentials
       inputEmail("timothy.pritchard@testpro.io");
       inputPassword("q9RQ8fbN");
       submitLogin();
       Thread.sleep(1000);
       // 6. Search for a song
       songSearch("there will");
       // 7. Click 'View All' button
       clickAll();
       // 8. click the first song in the search results
       firstSong();
       Thread.sleep(1000);
       // 9. Click 'Add to' button
       Thread.sleep(1000);
       addToButton();
       Thread.sleep(1000);
       // 10. Choose the playlist to add it to
       addToPlaylist("Tim");
       Thread.sleep(1000);
       // Assert the playlist has been created
       Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

   }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void addToPlaylist(String playlistName) {
        WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '" + playlistName + "')]"));
        playlist.click();
    }

    public void addToButton() {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
    }

    public void firstSong() {
        WebElement selectSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        selectSong.click();
    }

    public void clickAll() {
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
    }

    public void songSearch(String songName) {
       WebElement songSearch = driver.findElement(By.cssSelector("input[name='q']"));
        songSearch.sendKeys(songName);
        songSearch.click();
    }

}