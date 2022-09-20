package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutPage extends BasePage{
    private static SelenideElement firstNameInput = $x("//input[@id='BillingNewAddress_FirstName']");
    private static SelenideElement lastNameInput = $x("//input[@id='BillingNewAddress_LastName']");
    private static SelenideElement emailInput = $x("//input[@id='BillingNewAddress_Email']");
    private static ElementsCollection countries = $$x("//option");
    private static SelenideElement cityInput = $x("//input[@id='BillingNewAddress_City']");
    private static SelenideElement address1Input = $x("//input[@id='BillingNewAddress_Address1']");
    private static SelenideElement zipInput = $x("//input[@id='BillingNewAddress_ZipPostalCode']");
    private static SelenideElement phoneNumberInput = $x("//input[@id='BillingNewAddress_PhoneNumber']");
    private static ElementsCollection continueBtn = $$x("//div[@class='buttons']//input[@value='Continue']");
    private static SelenideElement groundRadioBtn = $x("//input[@id='shippingoption_0']");
    private static SelenideElement cashPaymentRadioBtn = $x("//input[@id='paymentmethod_0']");
    private static SelenideElement confirmBtn = $x("//div[@class='buttons']//input[@value='Confirm']");
    private static SelenideElement completedCheckoutSign = $x("//strong");

    private static SelenideElement stepTitle = $x("//li[@class='tab-section allow active']//div//h2");

    public void fillRequiredFieldsAndContinue(String first_name, String last_name,
                                   String email, String city,
                                   String address1, String zip, String phone_number){
        firstNameInput.setValue(first_name);
        lastNameInput.setValue(last_name);
        emailInput.setValue(email);
        cityInput.setValue(city);
        address1Input.setValue(address1);
        zipInput.setValue(zip);
        phoneNumberInput.setValue(phone_number);
    }

    public void selectRandomCountry(){
        countries.get((int) (Math.random()*countries.size())+1).click();
    }

    public void setGroundShipMethod(){
        groundRadioBtn.click();
    }

    public void setCashPaymentRadioBtn(){
        cashPaymentRadioBtn.click();
    }

    public void clickContinue(){
        continueBtn.findBy(Condition.visible).click();
    }

    public void clickConfirm(){
        confirmBtn.click();
    }

    public SelenideElement getStepTitle() {
        return stepTitle;
    }

    public String getCompletedCheckoutSign(){
        return completedCheckoutSign.shouldBe(Condition.visible).getText();
    }
}
