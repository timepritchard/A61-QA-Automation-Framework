import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletePlaylistNotification = "Deleted playlist";

        // removing because it is no longer necessary navigateToPage();
        inputEmail("timothy.pritchard@testpro.io");
        inputPassword("q9RQ8fbN");
        submitLogin();
        clickPlaylist();
        deleteSelectedPlaylist();
        Assert.assertEquals(getPlaylistNotification(), expectedDeletePlaylistNotification);


    }

    public String getPlaylistNotification() {
        //WebElement notification = driver.findElement(By.xpath("//div[@class='success show' and contains(text(), 'Deleted playlist')]"));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='success show' and contains(text(), 'Deleted playlist')]")));
        String notificationText = notification.getText();
        if (notificationText.contains("Deleted playlist")) {
            return "Deleted playlist";
        }
        return notification.getText();
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
        //WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@class='del btn-delete-playlist']")));
deletePlaylistButton.click();
    }

    public void clickPlaylist() {
        //WebElement playList = driver.findElement(By.xpath("(//li[@class='playlist playlist'])[2]"));
        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("(//li[@class='playlist playlist'])[2]")));
        playList.click();
    }
}
