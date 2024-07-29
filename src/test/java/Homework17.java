import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;

// can you please help?! When I run it I see it has searched for sailing day, but no results appear
// I tried to add a click in case it needed a click, and implicit waits in case it needed to wait for the results to load
// but none of this worked!
// Also, I'm confused, I'm using the same css locator twice: "button[type='submit']" and when I search it shows there aren't other locators with the same name, is this because they are on different pages so they can be repeated?
// Also, I know I should move the methods to BaseTest, but I want to get the test case working before I move them there!

public class Homework17 extends BaseTest {
   @Test
   public void addSongToPlaylist() {
       navigateToPage();
       // 5. Login with your credentials
       inputEmail("timothy.pritchard@testpro.io");
       inputPassword("q9RQ8fbN");
       submitLogin();
       // 6. Search for a song
       songSearch("sailing day");
       // 7. Click 'View All' button
       clickAll();
       // 8. click the first song in the search results
       firstSong();
       // 9. Click 'Add to' button
       addToButton();
       // 10. Choose the playlist to add it to
       addToPlaylist("Tim's first playlist");
       // Assert the playlist has been created
       assertPlaylist();

   }

    public void assertPlaylist() {
        WebElement notificationText = driver.findElement(By.cssSelector("class['alertify-logs top right']"));
        String actualNotificationText = notificationText.getText();
        String expectedNotificationText = "Created Playlist (playlistName)";
        Assert.assertEquals(actualNotificationText, expectedNotificationText);
    }

    public void addToPlaylist(String playlistName) {
        WebElement createPlaylist = driver.findElement(By.cssSelector("input[data-test='new-playlist-name']"));
        createPlaylist.sendKeys(playlistName);
        WebElement submitPlaylist = driver.findElement(By.cssSelector("button[type='submit']"));
        submitPlaylist.click();
    }

    public void addToButton() {
        WebElement addToBtn = driver.findElement(By.cssSelector("button[class='btn-add-to']"));
        addToBtn.click();
    }

    public void firstSong() {
        WebElement selectSong = driver.findElement(By.cssSelector("tr[class='song-item selected']"));
        selectSong.click();
    }

    public void clickAll() {
        WebElement viewAll = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAll.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void songSearch(String songName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement songSearch = driver.findElement(By.cssSelector("input[name='q']"));
        songSearch.sendKeys(songName);
        songSearch.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void submitLogin() {
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        loginBtn.click();
    }

    public void inputPassword(String password) {
        WebElement passField = driver.findElement(By.cssSelector("input[type='password']"));
        passField.clear();
        passField.sendKeys(password);
    }

    public void inputEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void navigateToPage() {
        String url = "https://qa.koel.app/";
        driver.get(url);
    }
}