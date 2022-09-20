package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SimpleComputerPage extends BasePage{
    private static SelenideElement processorRadioBtn = $x("//input[@id='product_attribute_75_5_31_96']");

    public void setProcessor(){
        processorRadioBtn.click();
    }
}
