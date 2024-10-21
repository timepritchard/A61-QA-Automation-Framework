package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArtistsPage extends BasePage{
    //Constructor
    public ArtistsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    By songThumbnail = By.xpath("//span[@class='thumbnail-wrapper']");
    By artistResults = By.xpath("//div[@class='artists main-scroll-wrap as-thumbnails']");
    //Helper Methods
    /*public List<WebElement> songsShown(){
        WebElement visibleThumbnail = findElement(songThumbnail); // This ensures we wait for the first visible thumbnail
        return driver.findElements(songThumbnail);
    }*/
    public WebElement songsShown(){
        return findElement(artistResults);
    }
}
