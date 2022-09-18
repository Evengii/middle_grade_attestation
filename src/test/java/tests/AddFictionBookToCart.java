package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import configs.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookPage;

import java.time.Duration;

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

public class AddFictionBookToCart extends BaseTest{

    @Test
    public void addBookToCart(){
        Selenide.open(Config.getBooks());
        BookPage bookPage = new BookPage();
        bookPage.openItemPage();
        String url = bookPage.getProductPageUrl();
        Assert.assertTrue(url.equals(Config.getFictionBookUrl()));

        bookPage.addToCart();
        Assert.assertTrue(bookPage.getNotificationToCart().shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed());

        bookPage.switchToCart();
        Assert.assertEquals(bookPage.getItemFictionInCartText(),"Fiction");
    }
}
