package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaylistPage extends BasePage{
    public PlaylistPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    By deletePlaylistButton = By.xpath("//button[@class='del btn-delete-playlist']");
    By notification = By.xpath("//div[@class='success show' and contains(text(), 'Deleted playlist')]");

    // Helper methods
    public void deleteSelectedPlaylist() {
        findElement(deletePlaylistButton).click();
    }

    public String getPlaylistNotification() {
        String notificationText = findElement(notification).getText();
        if (notificationText.contains("Deleted playlist")) {
            return "Deleted playlist";
        }
        return notificationText;
    }
}
