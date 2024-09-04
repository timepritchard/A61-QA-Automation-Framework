package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
public HomePage(WebDriver givenDriver){
    super(givenDriver);
}
//Elements
By userAvatarIcon = By.cssSelector("img.avatar");
By notificationBox = By.cssSelector("div.success.show");
By playlistName = By.cssSelector("[name='name']");
By secondPlaylistList = By.xpath("(//li[@class='playlist playlist'])[2]");
By allSongsTab = By.cssSelector("li a.songs");
String newPlaylistName = "Sample Edited Playlist";

    // Helper methods
public WebElement getUserAvatar(){
    return findElement(userAvatarIcon);
}
public String notificationText(){
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
}
