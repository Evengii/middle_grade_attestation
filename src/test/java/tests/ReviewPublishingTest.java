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
        Assert.assertTrue(booksPage.getPageUrl().equals(Config.getFictionBookUrl()));

        int beforeReviewing = fictionBookPage.getNumOfReviews();
        fictionBookPage.clickAddReviewBtn();
        fictionReviewPage.fillReviewSample("lorem", "lorem ipsum");
        Assert.assertTrue(fictionReviewPage.reviewAdded(), "Review not added");

        open(Config.getBooks());
        booksPage.openItemPage("Picture of Fiction");
        Assert.assertEquals(beforeReviewing + 1, fictionBookPage.getNumOfReviews(), "Num of reviews is not matched");
    }
}
