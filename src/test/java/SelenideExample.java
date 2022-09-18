import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class SelenideExample {
    @Test
    public void userCanLoginByUsername() {
        open("https://demoqa.com/text-box");
        $(By.id("userName")).setValue("johny");
        $(By.id("submit")).click();
        $(".loading_progress").should(disappear); // Waits until element disappears
        $(By.id("name")).shouldHave(text("johny")); // Waits until element gets text
    }
}
