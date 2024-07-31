import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletePlaylistNotification = "Deleted playlist";

        navigateToPage();
        inputEmail("timothy.pritchard@testpro.io");
        inputPassword("q9RQ8fbN");
        submitLogin();
        Thread.sleep(2000);
        clickPlaylist();
        deleteSelectedPlaylist();
        Assert.assertEquals(deletePlaylistNotification(), expectedDeletePlaylistNotification);


    }

    /* Only necessary if the playlist has a song in
    private void tapOk() {
        WebElement okButton = driver.findElement(By.cssSelector("button[class='ok']"));
        okButton.click();
    } */

    public String deletePlaylistNotification () {
        WebElement notification = driver.findElement(By.cssSelector(".div.success.show"));
        return notification.getText();
}


    public void deleteSelectedPlaylist() {
        WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));

    }

    public void clickPlaylist() {
        WebElement playList = driver.findElement(By.xpath("(//li[@class='playlist playlist'])[2]"));
        playList.click();
    }
}
