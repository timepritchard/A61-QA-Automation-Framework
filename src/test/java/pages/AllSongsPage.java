package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class AllSongsPage extends BasePage {


        //Elements
        By chooseSong = By.cssSelector("tr.song-item");
        By PlayButton = By.cssSelector("span[data-testid='play-btn']");
        By firstSong = By.cssSelector("tr.song-item:nth-child(1)");
        By tapPlay = By.cssSelector("li.playback");
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

        /*public void clickPlay () {
            WebElement playBtn = findElement(PlayButton);
            Actions actions = new Actions(driver);
            try {
                actions.moveToElement(playBtn).perform();
                actions.click().build().perform();
            } catch (TimeoutException e) {
                System.out.println("Standard click failed, trying JavaScript click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", playBtn);
            }
        }*/
        public boolean isSoundBarDisplayed () {
            return findElement(soundBar).isDisplayed();
        }

    }


