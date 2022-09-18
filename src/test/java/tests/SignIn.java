package tests;

import configs.Creds;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SignInPage;

public class SignIn extends BaseTest {

    @Test
    public void signIn(){
        MainPage mainPage = new MainPage();
        SignInPage signInPage = mainPage.clickLogin();
        signInPage.enterValues(Creds.getLOGIN(), Creds.getPASSWORD());
        signInPage.clickSubmit();
    }
}
