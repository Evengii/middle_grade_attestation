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
    Test to validate impossibility to add negative values
 */

public class AddNegativeQtyToCartTest extends BaseTest{
    BooksPage booksPage = new BooksPage();
    CartPage cartPage = new CartPage();

    @Test(groups = {"cart","negative"},
            description = "Adding negative quantity of items to the cart")
    public void addNegativeQty(){
        open(Config.getBooks());
        booksPage.openItemPage("Picture of Fiction");
        Assert.assertEquals(Config.getFictionBookUrl(), booksPage.getPageUrl());

        booksPage.setQuantityInput("-5");
        booksPage.addToCart();
        Assert.assertEquals(booksPage.getNotificationToCart().shouldBe(Condition.visible,
                Duration.ofSeconds(4)).getText(), "Quantity should be positive", "Cart is not opened");
    }
}
