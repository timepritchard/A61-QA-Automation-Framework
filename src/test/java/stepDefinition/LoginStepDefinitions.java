package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LoginStepDefinitions {

        WebDriver driver;
        LoginPage loginPage;
        HomePage homePage;

        // This hook runs before each scenario
        @Before
        public void setUp() {
            driver = WebDriverManager.getDriver();  // Initialize WebDriver from WebDriverManager
            loginPage = new LoginPage(driver);      // Initialize page objects after driver is ready
            homePage = new HomePage(driver);
        }

        // This hook runs after each scenario
        @After
        public void tearDown() {
            WebDriverManager.closeDriver();  // Ensures driver is properly closed after tests
        }


        @Given("I open the login page")
    public void iOpenLoginPage() {
        driver.get("https://qa.koel.app/");
    }
    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        loginPage.provideEmail(email);
    }
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.providePassword(password);
    }
    @And("I submit")
    public void iSubmit() {
        loginPage.clickSubmit();
    }
    @Then("I am logged in")
    public void iAmLoggedIn() {
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

}