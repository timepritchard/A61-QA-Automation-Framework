/*package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ProfilePageFactory extends BasePage {


    public ProfilePageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Page factory elements
    @FindBy(xpath = "//div[@class='name' and text()='Slate']")
    WebElement profileAvatar;
    @FindBy(css = ".theme selected")
    WebElement selectedBorder;

    //Helper Methods
    public void changeThemeToSlate(){
        waitForElement(profileAvatar).click();
    }
    public boolean themeSelected(){
        WebElement = waitForElement(selectedBorder).isDisplayed();
        return selectedBorder.isDisplayed();
    }
}*/