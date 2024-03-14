package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {
    SHAFT.GUI.WebDriver driver;
    public CheckoutPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By checkoutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private final By firstNameTxt = By.id("input-payment-firstname");
    private final By lastNameTxt = By.id("input-payment-lastname");
    private final By mobileTxt = By.id("input-payment-telephone");
    private final By addressTxt = By.id("input-payment-address-1");
    private final By cityTxt = By.id("input-payment-city");
    private final By landMarkTxt = By.id("input-payment-address-2");
    private final By postCodeTxt = By.id("input-payment-postcode");
    private final By continueButton = By.id("button-payment-address");
    private final By paymentMethode = By.id("cod");
    private final By confirmOrderButton = By.id("button-payment-method");
    private final By AssertionMessage = By.xpath("//p[text()='Your Order has been successfully done.']");

    public void navigateToCheckOutPage(){
        driver.element().click(checkoutButton);
    }
    public void enterUserData(String firstName, String lastName, String mobile, String address, String city, String landMark
    ,String postCode){
        driver.element().type(firstNameTxt,firstName);
        driver.element().type(lastNameTxt,lastName);
        driver.element().type(mobileTxt,mobile);
        driver.element().type(addressTxt,address);
        driver.element().select(cityTxt,city);
        driver.element().type(landMarkTxt,landMark);
        driver.element().type(postCodeTxt,postCode);
        driver.element().click(continueButton);
    }

    public void chosePaymentMethode() throws InterruptedException {
        driver.element().click(paymentMethode);
        driver.element().click(confirmOrderButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }
}
