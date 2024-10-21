package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage{
    public SearchResultsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    By songsResults = By.xpath("//ul//article[@data-test='song-card']");
    By playSong = By.xpath("//section[@data-testid='song-excerpts']//span[@class='cover']//a[@class='control']//i[@class='fa fa-play']");
    By pauseSong = By.xpath("//section[@data-testid='song-excerpts']//a[@class='control']//i[@class='fa fa-pause']");
    //By artistNameResults = By.xpath("//ul//article[@data-test='song-card']//span[@class='by text-secondary']//a[contains(text(), '" + artistName + "')]");

    //Helper methods
    public boolean songsByArtist(){
        return findElement(songsResults).isDisplayed();
    }
    public String checkArtistsName(String artistName){
        By artistNameResults = By.xpath("//ul//article[@data-test='song-card']//span[@class='by text-secondary']//a[contains(text(), '" + artistName + "')]");
        String artist = findElement(artistNameResults).getText();
        return artist;
    }
    public void playSearchedSong(){
        findElement(playSong).click();
    }
    public boolean songPlaying(){
        return findElement(pauseSong).isDisplayed();
    }
}
