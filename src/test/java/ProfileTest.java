/*import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.HomePageFactory;
import pageFactory.LoginPageFactory;
import pageFactory.ProfilePageFactory;

public class ProfileTest extends BaseTest {
@Test

    public void changeTheme(){
    LoginPageFactory loginPageFactory = new LoginPageFactory(BaseTest.driver);
    HomePageFactory homepageFactory = new HomePageFactory(BaseTest.driver);
    ProfilePageFactory profilePageFactory = new ProfilePageFactory(BaseTest.driver);

    loginPageFactory.provideEmail("timothy.pritchard@testpro.io");
    loginPageFactory.providePassword("q9RQ8fbN");
    loginPageFactory.clickSubmitBtn();
    homepageFactory.clickProfile();
    profilePageFactory.changeThemeToSlate();
    Assert.assertTrue(profilePageFactory.themeSelected().isDisplayed());
    }




}*/