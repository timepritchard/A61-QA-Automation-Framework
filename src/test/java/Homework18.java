import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException {

        navigateToPage();
        inputEmail("timothy.pritchard@testpro.io");
        inputPassword("q9RQ8fbN");
        submitLogin();
        allSongs();
        Thread.sleep(2000);
        playNextSong();
        Thread.sleep(5000);
WebElement pauseButton = driver.findElement(By.cssSelector("span[title=\"Pause\"]"));
Assert.assertTrue(pauseButton.isDisplayed());
    }

    public void playNextSong() {
    WebElement nextSong = driver.findElement(By.cssSelector("span[title=\"Play or resume\"]"));
    nextSong.click();
    }

    public void allSongs() {
        WebElement allSongsTab = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allSongsTab.click();
    }

}
