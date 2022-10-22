package tests;//made it abstract because we won't create class objects

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import configs.Config;
import org.testng.annotations.*;

abstract public class BaseTest {

    /*
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920*1080";
        Configuration.headless = false;
    }
     */

    @BeforeSuite(groups = {"positive", "negative"})
    static void allureReports(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }

    @BeforeMethod(groups = {"positive", "negative"})
    public void init(){
        //setUp();
        Selenide.open(Config.getBaseUrl());
    }

    @AfterMethod(groups = {"positive", "negative"})
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
