package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class PlaylistPageFactory extends BasePage {
    public PlaylistPageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }
    // Page factory elements
    @FindBy(xpath = "//button[@class='del btn-delete-playlist']")
    WebElement deletePlaylistButton;
    @FindBy(xpath = "//div[@class='success show' and contains(text(), 'Deleted playlist')]")
    WebElement notification;


    // Helper methods
    public void deleteSelectedPlaylist() {
        waitForElement(deletePlaylistButton).click();
    }

    public String getPlaylistNotification() {
        String notificationText = waitForElement(notification).getText();
        if (notificationText.contains("Deleted playlist")) {
            return "Deleted playlist";
        }
        return notification.getText();
    }
}
