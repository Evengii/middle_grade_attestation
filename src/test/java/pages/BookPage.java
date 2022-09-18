package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class BookPage {
    private final SelenideElement fictionBook = $(By.xpath("//div[@class='item-box']//img[@alt='Picture of Fiction']"));
    private final SelenideElement addToCartBtn = $(".button-1.add-to-cart-button");
    private final SelenideElement notificationToCart = $(By.xpath("//p[@class='content']"));
    private final SelenideElement notificationToCartBtn = $(By.xpath("//p[@class='content']//a[@href='/cart']"));
    private final SelenideElement itemFictionInCart = $(By.xpath("//td[@class='product']//a[text()='Fiction']"));

    public void openItemPage(){
        fictionBook.click();
    }


    public String getItemFictionInCartText() {
        return itemFictionInCart.getText();
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public void switchToCart(){
        notificationToCartBtn.click();
    }

    public SelenideElement getNotificationToCart() {
        return notificationToCart;
    }

    public String getProductPageUrl(){
        return webdriver().driver().url();
    }
}
