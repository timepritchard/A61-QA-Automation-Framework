package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CurrentQueuePage extends BasePage {
    public CurrentQueuePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    By tenthSong = By.xpath("(//*[@class='song-item'])[10]");
    By addToBtn = By.cssSelector(".btn-add-to");
    By topOfQueue = By.cssSelector(".top-queue");
    By firstSong = By.xpath("(//*[@class='song-item'])[1]");

    // Helper Methods
    public void selectTenthSong(){
        findElement(tenthSong).click();
    }
    public void clickAddToBtn(){
        findElement(addToBtn).click();
    }
    public void topOfQueue(){
        findElement(topOfQueue).click();
    }
    public String tenthSongName(){
        return findElement(tenthSong).getText();
    }
    public String firstSongName(){
        return findElement(firstSong).getText();
    }

}
