package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BookPage extends BasePage{
    private final SelenideElement fictionBook = $x("//div[@class='item-box']//img[@alt='Picture of Fiction']");

    public void openItemPage(){
        fictionBook.click();
    }

    public String getProductPageUrl(){
        return webdriver().driver().url();
    }
}
