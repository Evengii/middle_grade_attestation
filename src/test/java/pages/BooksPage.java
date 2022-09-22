package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class BooksPage extends BasePage{
    private final SelenideElement fictionBook = $x("//div[@class='item-box']//img[@alt='Picture of Fiction']");
    private final SelenideElement lowToHighDropdown = $(By.id("products-orderby"));
    private final ElementsCollection bookPrices = $$x("//span[@class='price actual-price']");

    public void selectLowToHigh(){
        lowToHighDropdown.selectOption("Price: Low to High");
    }

    public List<Float> getBookPrices(){
        List<Float> temp = new ArrayList<>();
        for (SelenideElement bookPrice : bookPrices) {
            temp.add(Float.parseFloat(bookPrice.getText()));
        }
        return temp;
    }

    public void openItemPage(){
        fictionBook.click();
    }

    public String getProductPageUrl(){
        return webdriver().driver().url();
    }
}
