package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    String nameOfPlaylist = "Tim";
    //Elements
    By userAvatarIcon = By.cssSelector("img.avatar");
    By notificationBox = By.cssSelector("div.success.show");
    By playlistName = By.cssSelector("[name='name']");
    By secondPlaylistList = By.xpath("(//li[@class='playlist playlist'])[2]");
    By allSongsTab = By.cssSelector("li a.songs");
    By songSearch = By.cssSelector("input[name='q']");
    By viewAll = By.cssSelector("button[data-test='view-all-songs-btn']");
    By selectSong = By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]");
    By addToBtn = By.cssSelector("button[class='btn-add-to']");
    By playlist = By.xpath("//*[@id='songResultsWrapper']//*[contains(text(), '" + nameOfPlaylist + "')]");
    String newPlaylistName = "Sample Edited Playlist";


    // Helper methods
    public WebElement getUserAvatar() {
        return findElement(userAvatarIcon);
    }
    public String notificationText() {
        return findElement(notificationBox).getText();
    }
    public void inputNewName() {
        findElement(playlistName).sendKeys(newPlaylistName);
        findElement(playlistName).sendKeys(Keys.ENTER);
    }
    public void clearPlaylist() {
        findElement(playlistName).sendKeys(Keys.COMMAND, "a", Keys.DELETE);
    }
    public void selectPlaylist() {
        WebElement secondPlaylist = findElement(secondPlaylistList);
        Actions actions = new Actions(driver);
        actions.doubleClick(secondPlaylist).perform();
    }
    public void allSongs() {
        findElement(allSongsTab).click();
    }
    public void clickPlaylist() {
        findElement(secondPlaylistList).click();
    }
    public void songSearch(String songName) {
        findElement(songSearch).sendKeys(songName);
        findElement(songSearch).click();
    }
    public void clickAll() {
        findElement(viewAll).click();
    }
    public void firstSong() {
        findElement(selectSong).click();
    }
    public void addToButton() {
        findElement(addToBtn).click();
    }
    public void addToPlaylist(String nameOfPlaylist) {
        findElement(playlist).click();
    }
}
