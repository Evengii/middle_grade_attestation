package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/*
 1. Create ElementCollection for elements in the cart
 2. Create method with input String to get needed element
 */

public class CartPage {
    private final SelenideElement itemFictionInCart = $x("//td[@class='product']//a[text()='Fiction']");
    private final SelenideElement itemSimpleComputerInCart = $x("//td[@class='product']//a[text()='Simple Computer']");
    private final SelenideElement termsOfUseCheckbox = $x("//input[@id='termsofservice']");
    private final SelenideElement checkoutBtn = $x("//button[@id='checkout']");

    public String getItemFictionInCartText() {
        return itemFictionInCart.getText();
    }

    public String getItemSimpleComputerInCart() {
        return itemSimpleComputerInCart.getText();
    }

    public void checkTermsOfUse(){
        termsOfUseCheckbox.click();
    }

    public CheckoutLoginPage clickCheckout(){
        checkoutBtn.click();
        return new CheckoutLoginPage();
    }
}
