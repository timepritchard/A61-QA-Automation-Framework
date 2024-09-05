import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{

    String newPlaylistName = "Sample Edited Playlist";
    @Test
    public void renamePlaylist(){
        //define the new playlist name

        //define the expected notification message of the new playlist
        String expectedMessage = "Updated playlist \"Sample Edited Playlist.\"";
        //Login
        inputEmail("timothy.pritchard@testpro.io");
        inputPassword("q9RQ8fbN");
        submitLogin();
        //double click on a playlist
        selectPlaylist();
        //clear previous name
        clearPlaylist();
        //add new name
        inputNewName();
        //assert the notification shows the new playlist name
        Assert.assertEquals(notificationText(), expectedMessage);


    }
public String notificationText(){
        WebElement textNotification = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return textNotification.getText();

}


    public void inputNewName() {
        WebElement newName = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[name='name']")));
        newName.sendKeys(newPlaylistName);
        newName.sendKeys(Keys.ENTER);

    }

    public void clearPlaylist() {
WebElement playlistClear = wait.until(ExpectedConditions.visibilityOfElementLocated
        (By.cssSelector("[name='name']")));
        playlistClear.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.DELETE));
    }

    public void selectPlaylist() {
        WebElement playlistSelected = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//li[@class='playlist playlist'][2]")));
        actions.doubleClick(playlistSelected).perform();

    }
}
