package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPageFactory extends BasePage {

    public LoginPageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }
    // Page factory elements
    @FindBy(css = "[type='submit']")
    WebElement submitBtn;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type= 'password']")
    WebElement passwordField;

    // Helper methods
    public void clickSubmitBtn(){
        submitBtn.click();
    }
    public void provideEmail(String email){
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        passwordField.sendKeys(password);
    }
}
