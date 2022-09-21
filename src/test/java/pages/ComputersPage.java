package pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.*;

public class ComputersPage extends BasePage{
    private final SelenideElement desktops = $x("//h2//a[@href='/desktops']");

    public DesktopsPage openDesktopPage() {
        desktops.click();
        return new DesktopsPage();
    }
}
