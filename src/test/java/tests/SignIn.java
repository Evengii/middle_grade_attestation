package tests;

import configs.Creds;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignInPage;

public class SignIn extends BaseTest {

    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();
    @Test
    public void signIn(){
        mainPage.clickLogin();
        signInPage.enterValues(Creds.getLOGIN(), Creds.getPASSWORD());
        signInPage.clickSubmit();
    }
}
