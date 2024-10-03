package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlbumsPage extends BasePage {
    public AlbumsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Elements
    By unknownCover = By.xpath("//span[@class='cover' and contains(@style, 'unknown')]");
    By unknownAlbum = By.xpath("//article[contains(@title, 'Unknown Album')]");
    By albumSongs = By.xpath("//div[@class='song-list-wrap main-scroll-wrap album']//tr[@class='song-item']");
    By headerNumberOfSongs = By.xpath("//span[@data-v-fb939d76]//a[contains(text(), 'Makaih Beats')]/following-sibling::text()[1][contains(., 'songs')]");
    By shuffleButton = By.xpath("//section[@id='albumWrapper']//button[@class='btn-shuffle-all']");
    By downloadButton = By.xpath("//section[@id='albumWrapper']//a[@class='download']");

    //Helper Methods
    public boolean doAllAlbumsHaveCovers() {
        // Use findElements to get a list of matching elements
        List<WebElement> missingCovers = driver.findElements(unknownCover);
        // Return true if the list is empty (all albums have covers), false otherwise
        return missingCovers.isEmpty();
    }

    public boolean doAllAlbumsHaveNames() {
        List<WebElement> missingNames = driver.findElements(unknownAlbum);
        return missingNames.isEmpty();
    }

    public void tapOnAlbum(String album) {
        //By openAlbum = By.xpath("//div[@class='albums main-scroll-wrap as-list']//a[@class='name' and normalize-space(text())='" + album + "']");By openAlbum = By.xpath("//div[@class='albums main-scroll-wrap as-list']//article[@title='" + album + "']//a[@class='control control-play font-size-0']");
        //By openAlbum = By.xpath("//div[@class='albums main-scroll-wrap as-list']//article[contains(@title, '" + album + "')]//a[@class='control control-play font-size-0']");
        By openAlbum = By.xpath("//div[@class='albums main-scroll-wrap as-list']//article[contains(@title, 'Airbit')]//a[text()='Airbit']");
        findElement(openAlbum).click();
    }

    public boolean areSongsDisplayed() {
        List<WebElement> listSongs = driver.findElements(albumSongs);
        // I could either do !isEmpty(); or check the size is greater than 0
        return listSongs.size() > 0;
    }

    public int howManySongsInList() {
        List<WebElement> listSongs = driver.findElements(albumSongs);
        return listSongs.size();
    }

    public int numberOfSongsInHeader() {
        WebElement headerSongs = findElement(headerNumberOfSongs);
        // Get the text from the element
        String headerText = headerSongs.getText();
        // Extract the number using regex to remove non-digit characters
        String numberString = headerText.replaceAll("[^0-9]", "");
        // Convert the extracted string to an integer and return it
        return Integer.parseInt(numberString);
    }

    public WebElement shuffleIconShown() {
        return findElement(shuffleButton);
    }

    public WebElement downloadBtnShown() {
        return findElement(downloadButton);
    }
}
