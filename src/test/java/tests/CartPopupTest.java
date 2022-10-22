package tests;

import configs.Config;
import configs.Creds;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.MainPage;
import pages.SignInPage;
import static com.codeborne.selenide.Selenide.open;

/*
    1. Open Main page and hover the Shopping cart button
        Assert Popup is appeared
    2. Click on Go to Cart button
        Assert Cart is opened
 */

public class CartPopupTest extends BaseTest{
    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();
    CartPage cartPage = new CartPage();

    @Test(groups = {"cart", "positive"},
            description = "Checking cart popup appeared")
    public void usingCartPopup(){
        mainPage.clickLogin();
        signInPage.enterValues(Creds.getLOGIN(), Creds.getPASSWORD());
        signInPage.clickSubmit();

        open(Config.getBaseUrl());
        mainPage.shoppingCartHovering();
        mainPage.goToCartByPopup();
        Assert.assertEquals(cartPage.getPageUrl(), Config.getCart());
    }
}
