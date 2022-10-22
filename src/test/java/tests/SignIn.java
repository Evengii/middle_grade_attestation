package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import configs.Config;
import configs.Creds;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignInPage;

public class SignIn extends BaseTest {

    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();



    @Test(groups = {"positive"})
    public void signIn(){
        mainPage.clickLogin();
        signInPage.enterValues(Creds.getLOGIN(), Creds.getPASSWORD());
        signInPage.clickSubmit();
        Assert.assertTrue(mainPage.getLogoutBtn().isDisplayed(),
                "Login was unsuccessful");
    }

    @Test(groups = {"negative"})
    public void signInWithInvalidCreds() {
        mainPage.clickLogin();
        signInPage.enterValues(Creds.getWrongEmail(), Creds.getPASSWORD());
        signInPage.clickSubmit();
        Assert.assertEquals(signInPage.getInvalidLoginMessage(),
                "Login was unsuccessful. Please correct the errors and try again.",
                "Error message is missed");
    }
}
