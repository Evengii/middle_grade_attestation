package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutLoginPage extends BasePage{
    private static SelenideElement checkoutAsGuestBtn = $x("//input[@class='button-1 checkout-as-guest-button']");

    public CheckoutPage clickCheckoutAsGuest (){
        checkoutAsGuestBtn.click();
        return new CheckoutPage();
    }
}
