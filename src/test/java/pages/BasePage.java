package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private final SelenideElement addToCartBtn = $(".button-1.add-to-cart-button");
    private final SelenideElement notificationToCart = $x("//p[@class='content']");
    private final SelenideElement notificationToCartBtn = $x("//p[@class='content']//a[@href='/cart']");
    private SelenideElement itemPage(String item){
        return $x("//div[@class='item-box']//img[@alt='" + item + "']");
    }

    protected String getTitleText(String titleName) {
        String title = "//h1[contains(text(), '%s')]";
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

    public void switchToCart(){
        notificationToCartBtn.click();
    }

    public SelenideElement getNotificationToCart() {
        return notificationToCart;
    }

    public void openItemPage(String item){
        itemPage(item).click();
    }
}
