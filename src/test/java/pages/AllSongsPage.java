package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class AllSongsPage extends BasePage {


        //Elements
        By chooseSong = By.cssSelector("tr.song-item");
        By PlayButton = By.cssSelector("span[data-testid='play-btn']");
        By firstSong = By.cssSelector("tr.song-item:nth-child(1)");
        By tapPlay = By.cssSelector("li.playback");
    By heartSeventhSong = By.xpath("(//div[@class='song-list-wrap main-scroll-wrap all-songs']//i[contains(@class, 'fa fa-heart-o')])[1]");
    By topSongName = By.xpath("(//section[@id='songsWrapper']//td[@class='title'])[1]");

//constructor
        public AllSongsPage(WebDriver givenDriver) {
            super(givenDriver);
        }
        //Helper Methods
        public void allSongs () {
            findElement(chooseSong).click();
        }
        public void contextClickFirstSong(){
            WebElement firstSongInList = findElement(firstSong);
            Actions actions = new Actions(driver);
            actions.contextClick(firstSongInList).perform();
        }
        public void tapPlay(){
            findElement(tapPlay).click();
        }

        public boolean isSoundBarDisplayed () {
            return findElement(soundBar).isDisplayed();
        }
        public void favoriteSong(String song){
            // need to add the find element here to use the variable song in the method
            By heartBtn = By.xpath("(//div[@class='song-list-wrap main-scroll-wrap all-songs'])//button[@data-test='like-btn' and contains(@title, 'Like " + song + "')]");
            findElement(heartBtn).click();
        }
    }


