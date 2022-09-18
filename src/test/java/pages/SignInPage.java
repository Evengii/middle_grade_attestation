package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private final SelenideElement email = $(By.id("Email"));
    private final SelenideElement password = $(By.id("Password"));
    private final SelenideElement submitBtn = $(".button-1.login-button");

    public void enterValues(String user, String pass){
        email.val(user);
        password.val(pass);
    }

    public void clickSubmit(){
        submitBtn.click();
    }
}
