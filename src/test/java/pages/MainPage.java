package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement loginBtn = $(".ico-login");

    public SignInPage clickLogin(){
        loginBtn.click();
        return new SignInPage();
    }
}
