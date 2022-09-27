package tests;

import configs.Config;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

/*
    1. Write 'cam' to search box and wait till the list with suggestions appeared
        Assert the list appeared
    2. Put the suggestions to the list and select 'Camcorder'
        Assert Camcorder's page is opened
 */

public class CamcorderSearchingTest {

    MainPage mainPage = new MainPage();

    @Test
    public void searchCamcorder(){
        open(Config.getBaseUrl());
        mainPage.typeInSearch("cam");
        Assert.assertTrue(mainPage.suggestionListAppeared(), "Suggestions list not appeared");

        mainPage.clickNeededItem("Camcorder");
        Assert.assertTrue(mainPage.getPageUrl().equals(Config.getCamcorderPage()));
    }
}
