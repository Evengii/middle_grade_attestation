package tests;//made it abstract because we won't create class objects

import com.codeborne.selenide.Selenide;
import configs.Config;
import configs.Creds;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.SignInPage;

abstract public class BaseTest {

    /*
    public void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920*1080";
        Configuration.headless = false;
    }
     */

    @BeforeClass
    public void init(){
        //setUp();
        Selenide.open(Config.getBaseUrl());
    }

    @AfterClass
    public void tearDown() {

        Selenide.closeWebDriver();
    }
}
