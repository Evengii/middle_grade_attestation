package tests;

import com.codeborne.selenide.Condition;
import configs.Config;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
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

    BooksPage booksPage = new BooksPage();
    CartPage cartPage = new CartPage();

    @Test
    public void addBookToCart(){
        open(Config.getBooks());
        booksPage.openItemPage("Picture of Fiction");;
        Assert.assertTrue(booksPage.getPageUrl().equals(Config.getFictionBookUrl()));

        booksPage.addToCart();
        Assert.assertTrue(booksPage.getNotificationToCart().shouldBe(Condition.visible,
                Duration.ofSeconds(4)).isDisplayed(),"Cart is not opened");

        booksPage.switchToCart();
        Assert.assertEquals(cartPage.getItemFictionInCartText(),"Fiction");
    }
}
