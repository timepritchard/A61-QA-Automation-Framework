package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    // Constructor to accept the WebDriver instance
    public BasePage(WebDriver givenDriver) {
        this.driver = givenDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Setting wait time
        this.actions = new Actions(driver); // For complex user actions
        PageFactory.initElements(driver, this); // Initialize page elements
    }
// create a method for the wait
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    // Generic method for clicking using Actions class
    public void clickUsingActions(WebElement element) {
        actions.moveToElement(element).click().build().perform();
    }
    // create a method for the @findby wait
    public WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    // Elements
    By soundBar = By.cssSelector("[data-testid = 'sound-bar-play']");
    //Helper methods
    public boolean isSoundBarDisplayed() {
        return findElement(soundBar).isDisplayed();
    }
}
