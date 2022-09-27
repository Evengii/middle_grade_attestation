package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FictionBookPage extends BasePage{
    private static SelenideElement reviewsBtn = $x("//div[@class='product-review-links']//a");

    public int getNumOfReviews(){
        String [] arr = reviewsBtn.getText().split(" ");
        System.out.println(Integer.parseInt(arr[0]));
        return Integer.parseInt(arr[0]);
    }

    public FictionBookPage clickAddReviewBtn(){
        reviewsBtn.click();
        return new FictionReviewPage();
    }

    public class FictionReviewPage extends FictionBookPage{
        private static SelenideElement reviewTitle = $(By.id("AddProductReview_Title"));
        private static SelenideElement reviewText = $(By.id("AddProductReview_ReviewText"));
        private static SelenideElement rating = $(By.id("addproductrating_3"));
        private static SelenideElement submitReview = $x("//input[@name='add-review']");
        private static SelenideElement reviewAddedSign = $x("//div[@class='result']");

        public void fillReviewSample(String title, String text){
            reviewTitle.setValue(title);
            reviewText.setValue(text);
            rating.click();
            submitReview.click();
        }

        public boolean reviewAdded(){
            return reviewAddedSign.isDisplayed();
        }
    }
}
