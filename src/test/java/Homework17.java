import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


public class Homework17 extends BaseTest {
   @Test
   public void addSongToPlaylist() throws InterruptedException {
       String playlistName = "Tim";
       String expectedSongAddedMessage = "Added 1 song into \"" + playlistName + ".\"";
       // no longer needed: navigateToPage();
       // 5. Login with your credentials
       inputEmail("timothy.pritchard@testpro.io");
       inputPassword("q9RQ8fbN");
       submitLogin();
       // 6. Search for a song
       songSearch("lament");
       // 7. Click 'View All' button
       clickAll();
       // 8. click the first song in the search results
       firstSong();
       // 9. Click 'Add to' button
       addToButton();
       // 10. Choose the playlist to add it to
       addToPlaylist("Tim");
       // Assert the playlist has been created
       Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);

   }

    public String getAddToPlaylistSuccessMsg() {
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notification.getText();
    }

    public void addToPlaylist(String playlistName) {
       //WebElement playlist = driver.findElement(By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '" + playlistName + "')]"));
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '" + playlistName + "')]")));
        playlist.click();
    }

    public void addToButton() {
        //WebElement addToBtn = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        WebElement addToBtn = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button[class='btn-add-to']")));
        addToBtn.click();
    }

    public void firstSong() {
        //WebElement selectSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        WebElement selectSong = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        selectSong.click();
    }

    public void clickAll() {
        //WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        WebElement viewAll = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAll.click();
    }

    public void songSearch(String songName) {
       //WebElement songSearch = driver.findElement(By.cssSelector("input[name='q']"));
        WebElement songSearch = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("input[name='q']")));
        songSearch.sendKeys(songName);
        songSearch.click();
    }

}