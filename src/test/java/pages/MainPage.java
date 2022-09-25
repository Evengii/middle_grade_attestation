package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage{
    private final SelenideElement loginBtn = $(".ico-login");
    private final SelenideElement searchInput = $x("//input[@id='small-searchterms']");
    private final SelenideElement suggestionsList = $x("//ul[contains(@style,'display: block')]");
    private final ElementsCollection suggestionsItems = $$x("//li[@class='ui-menu-item']//a");

    public SignInPage clickLogin(){
        loginBtn.click();
        return new SignInPage();
    }

    public void typeInSearch(String item){
        searchInput.setValue(item).shouldBe();
    }

    public boolean suggestionListAppeared(){
        return suggestionsList.shouldBe(Condition.visible, Duration.ofSeconds(4)).isDisplayed();
    }

    public void clickNeededItem(String item){
        for(SelenideElement selenideElement : suggestionsItems){
            if(selenideElement.getText().equals(item)) {
                selenideElement.click();
                break;
            }
        }
    }
}
