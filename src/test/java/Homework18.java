import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {

        // no longer needed: navigateToPage();
        inputEmail("timothy.pritchard@testpro.io");
        inputPassword("q9RQ8fbN");
        submitLogin();
        allSongs();
        selectSong();
        playNextSong();
        clickPlay();
        Assert.assertTrue(isDisplayedPlayingSong());
    }

    public void clickPlay() {
        //WebElement playButton = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        WebElement playButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("span[data-testid='play-btn']")));
        playButton.click();
    }

    public void playNextSong() {
        //WebElement nextSong = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        WebElement nextSong = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("i[data-testid='play-next-btn']")));
        nextSong.click();
    }

    public boolean isDisplayedPlayingSong() {
            //WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        WebElement songIsPlaying = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-testid = 'sound-bar-play']")));
            return songIsPlaying.isDisplayed();
        }


    public void selectSong() {
        //WebElement song = driver.findElement(By.cssSelector("tr.song-item"));
        WebElement song = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("tr.song-item")));
        song.click();
    }

   /* public void playNextSong() {
    WebElement nextSong = driver.findElement(By.cssSelector("span[title=\"Play or resume\"]"));
        Actions actions = new Actions(driver);
        actions.click(nextSong).perform();
    } */

    public void allSongs() {
        //WebElement allSongsTab = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        WebElement allSongsTab = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("a[href='#!/songs']")));
        allSongsTab.click();
    }

}
