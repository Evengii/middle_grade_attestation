package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import configs.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.BookPage;
import pages.CartPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

/*
 * Add Fiction book to the cart
 * 1. Open main page
 * 2. Find the Fiction book and click on image
 *      Assert Fiction page open (url)
 * 3. Click on Add to cart button
 *      Assert the sigh is appeared (The product has been added to your shopping cart)
 * 4. Switch to the cart by appeared sign
 *      Assert the Fiction is in cart, compare with existing items
 */

public class AddFictionBookToCartTest extends BaseTest{

    BookPage bookPage = new BookPage();
    CartPage cartPage = new CartPage();

    @Test
    public void addBookToCart(){
        open(Config.getBooks());
        bookPage.openItemPage();
        String url = bookPage.getProductPageUrl();
        Assert.assertTrue(url.equals(Config.getFictionBookUrl()));

        bookPage.addToCart();
        Assert.assertTrue(bookPage.getNotificationToCart().shouldBe(Condition.visible,
                Duration.ofSeconds(4)).isDisplayed(),"Cart is not opened");

        bookPage.switchToCart();
        Assert.assertEquals(cartPage.getItemFictionInCartText(),"Fiction");
    }
}
