package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

public class BooksPage extends BasePage{
    private final SelenideElement lowToHighDropdown = $(By.id("products-orderby"));
    private final ElementsCollection bookPrices = $$x("//span[@class='price actual-price']");

    private final SelenideElement quantityInput = $x("//input[@id='addtocart_45_EnteredQuantity']");

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

    public void setQuantityInput(String quantity){
        quantityInput.setValue(quantity);
    }


}
