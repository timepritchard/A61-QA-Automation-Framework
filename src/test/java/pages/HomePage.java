package pages;

import org.openqa.selenium.*;
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
    By currentQueue = By.cssSelector(".queue.active");
    By addPlaylist = By.cssSelector(".fa.fa-plus-circle.create");
    By newPlaylist = By.cssSelector("[data-testid='playlist-context-menu-create-simple']");
    By favorites = By.cssSelector("a[href='#!/favorites']");
    By homePage = By.cssSelector("a.home[href='#!/home']");
    By albums = By.cssSelector("[href='#!/albums']");
    By albumContent = By.cssSelector(".albums.main-scroll-wrap.as-list");
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

    public void tapCurrentQueue() {
        findElement(currentQueue).click();
    }

    public void plusBtnPlaylist() {
        findElement(addPlaylist).click();
    }

    public void addNewPlaylist() {
        findElement(newPlaylist).click();
    }

    public void typeNewName(String inputPlaylistName) {
        findElement(playlistName).sendKeys(inputPlaylistName);
        findElement(playlistName).sendKeys(Keys.ENTER);
    }

    public boolean playlistNotification() {
        return findElement(notificationBox).isDisplayed();
    }

    public void favoriteList() {
        findElement(favorites).click();
    }

    public void homePageTab() {
        findElement(homePage).click();
    }

    public void albumsList() {
        try {
            // Wait and click the album element
            WebElement albumElement = wait.until(ExpectedConditions.elementToBeClickable(albums));
            albumElement.click();

            // Wait for the album content to load
            WebElement contentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(albumContent));
            System.out.println("Albums loaded successfully.");
        } catch (TimeoutException e) {
            System.out.println("Albums failed to load. Refreshing the page...");
            driver.navigate().refresh();

            // Retry clicking the album element after refresh
            WebElement albumElement = wait.until(ExpectedConditions.elementToBeClickable(albums));
            albumElement.click();
        }

    }
}

