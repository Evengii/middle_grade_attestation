package tests;


import com.codeborne.selenide.Condition;
import configs.Config;
import configs.Creds;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

/*
 * 1. Open Computers page
 *      Assert https://demowebshop.tricentis.com/computers is opened.
 * 2. Move to Desktops section
 *      Assert https://demowebshop.tricentis.com/desktops is opened.
 * 3. Select Simple computer by clicking on image
 *      Assert https://demowebshop.tricentis.com/simple-computer is opened
 * 4. Select parameters by radio buttons
 * 5. Click Add to cart
 * 6. Move to Cart.
 *      Assert computer is added and quantity is 1.
 * 7. Accept terms of use and click on checkout
 *      Assert https://demowebshop.tricentis.com/onepagecheckout is opened
 * 8. Fill required fields, select country and click Continue
 *      Assert items with Creds
 * 9. Proceed with selected address, Ground shipping method, Cash payment, payment info
 *      Assert all signs in dialogs
 * 10. Click confirm
 *      Assert Your order has been successfully processed! appered
 *      and https://demowebshop.tricentis.com/checkout/completed/ opened
 * 11. Go to the Cart
 *      Assert Your Shopping Cart is empty! appeared
 */


public class BuyDesktopTest extends BaseTest{

    ComputersPage computersPage = new ComputersPage();
    DesktopsPage desktopsPage = new DesktopsPage();
    SimpleComputerPage simpleComputerPage = new SimpleComputerPage();
    CartPage cartPage = new CartPage();
    CheckoutLoginPage checkoutLoginPage = new CheckoutLoginPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void buyDesktop() {
        open(Config.getComputers());
        computersPage.openDesktopPage();
        Assert.assertEquals(desktopsPage.getPageUrl(),
                Config.getDesktops(), "Desktops page is not opened");

        desktopsPage.openSimpleComputerPage();
        Assert.assertEquals(simpleComputerPage.getPageUrl(),
                Config.getSimpleComputer(), "Simple computer page is not opened");

        simpleComputerPage.setProcessor();
        simpleComputerPage.addToCart();
        Assert.assertTrue(simpleComputerPage.getNotificationToCart().shouldBe(Condition.visible,
                Duration.ofSeconds(4)).isDisplayed(), "Cart is not opened");

        simpleComputerPage.switchToCart();
        Assert.assertEquals(cartPage.getItemSimpleComputerInCart(), "Simple Computer");

        cartPage.checkTermsOfUse();
        cartPage.clickCheckout();
        Assert.assertEquals(checkoutLoginPage.getPageUrl(),
                Config.getLoginCheckout(), "Checkout login page page is not opened");

        checkoutLoginPage.clickCheckoutAsGuest();
        Assert.assertEquals(checkoutPage.getPageUrl(),
                Config.getCheckout(), "Checkout page is not opened");

        checkoutPage.fillRequiredFieldsAndContinue
                (Creds.getFirstName(),Creds.getLastName(),Creds.getEmail(),
                        Creds.getAddress(),Creds.getCity(),Creds.getZip(),Creds.getPhoneNumber());
        checkoutPage.selectRandomCountry();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getStepTitle().shouldBe(Condition.exactText("Shipping Address"),
                Duration.ofSeconds(4)).getText(), "Shipping Address", "Shipping address step not opened");

        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getStepTitle().shouldBe(Condition.exactText("Shipping Method"),
                Duration.ofSeconds(4)).getText(), "Shipping Method", "Shipping method step not opened");

        checkoutPage.setGroundShipMethod();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getStepTitle().shouldBe(Condition.exactText("Payment Method"),
                Duration.ofSeconds(4)).getText(), "Payment Method", "Payment Method step not opened");

        checkoutPage.setCashPaymentRadioBtn();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getStepTitle().shouldBe(Condition.exactText("Payment Information"),
                Duration.ofSeconds(4)).getText(), "Payment Information", "Payment Information step not opened");

        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getStepTitle().shouldBe(Condition.exactText("Confirm Order"),
                Duration.ofSeconds(4)).getText(), "Confirm Order", "Confirm Order step not opened");

        checkoutPage.clickConfirm();
        Assert.assertEquals(checkoutPage.getCompletedCheckoutSign(), "Your order has been successfully processed!",
                "There is no completed checkout sign");
    }
}
