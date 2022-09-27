package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DigitalDownloadsPage extends BasePage{
    private static SelenideElement downloadBtn = $x("//a[@href='/download/sample/51']");

    public SelenideElement getDownloadBtn() {
        return downloadBtn;
    }
}
