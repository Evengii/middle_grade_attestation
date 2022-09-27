package tests;

import configs.Config;
import configs.Creds;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.FictionBookPage;
import pages.MainPage;
import pages.SignInPage;
import static com.codeborne.selenide.Selenide.open;

/*
    1. Open book page
        Assert page is opened
    2. Get num of reviews
    3. Click Add review button
        Assert review's page is opened
    4. Fill the input fields
        Assert confirmation sigh is appeared
    5. Return to book page
        Assert the num of reviews increased by 1
 */

public class ReviewPublishingTest extends BaseTest{
    BooksPage booksPage = new BooksPage();
    FictionBookPage fictionBookPage = new FictionBookPage();
    FictionBookPage.FictionReviewPage fictionReviewPage = new FictionBookPage().new FictionReviewPage();
    MainPage mainPage = new MainPage();
    SignInPage signInPage = new SignInPage();

    @Test
    public void reviewPublishing(){
        mainPage.clickLogin();
        signInPage.enterValues(Creds.getLOGIN(), Creds.getPASSWORD());
        signInPage.clickSubmit();

        open(Config.getBooks());
        booksPage.openItemPage("Picture of Fiction");
        Assert.assertEquals(Config.getFictionBookUrl(), booksPage.getPageUrl());

        int beforeReviewing = fictionBookPage.getNumOfReviews();
        fictionBookPage.clickAddReviewBtn();
        fictionReviewPage.fillReviewSample("lorem", "lorem ipsum");
        Assert.assertTrue(fictionReviewPage.reviewAdded(), "Review not added");

        open(Config.getBooks());
        booksPage.openItemPage("Picture of Fiction");
        Assert.assertEquals(beforeReviewing + 1, fictionBookPage.getNumOfReviews(), "Num of reviews is not matched");
    }
}
