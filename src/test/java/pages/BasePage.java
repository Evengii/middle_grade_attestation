package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private final SelenideElement addToCartBtn = $(".button-1.add-to-cart-button");
    private final SelenideElement notificationToCart = $x("//p[@class='content']");
    private final SelenideElement notificationToCartBtn = $x("//p[@class='content']//a[@href='/cart']");

    private String title = "//h1[contains(text(), '%s')]";
    protected String getTitleText(String titleName) {
        System.out.println(title);
        System.out.println(String.format(title, titleName));
        return $x(String.format(title, titleName)).shouldBe(Condition.visible, Duration.ofSeconds(4)).text();
    }

    public String getPageUrl(){
        return webdriver().driver().url();
    }

    public void addToCart(){
        addToCartBtn.click();
    }

    public CartPage switchToCart(){
        notificationToCartBtn.click();
        return new CartPage();
    }

    public SelenideElement getNotificationToCart() {
        return notificationToCart;
    }
}
