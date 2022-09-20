package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;

public class DesktopsPage extends BasePage{
    private static SelenideElement simpleComputerBtn = $x("//h2//a[@href='/simple-computer']");

    public SimpleComputerPage openSimpleComputerPage(){
        simpleComputerBtn.click();
        return new SimpleComputerPage();
    }
}
