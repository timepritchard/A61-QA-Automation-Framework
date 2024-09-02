package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePageFactory extends BasePage {
    public HomePageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }
    // Page factory elements
    @FindBy(xpath = "(//li[@class='playlist playlist'])[2]")
    WebElement playlist;
    @FindBy(css = "a .avatar")
    WebElement profileAvatar;

    // Helper methods
    public void clickPlaylist(){
        waitForElement(playlist).click();
    }
    public void clickProfile(){
        waitForElement(profileAvatar).click();

    }
}
