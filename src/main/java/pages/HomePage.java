package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class HomePage {
    SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    
    private final By accountManagerIcon = By.cssSelector("body > div.page-wrapper > header > div.sticky-wrapper > div > div > div.header-right > div.dropdown.cart-dropdown.clsMobileLogin > a > svg");
    private final By signUpButton = By.xpath("//*[@id=\"clsLoginregister\"]/div[2]/div[1]/a[3]");
    private final By ContactUsPage = By.cssSelector("body > div.page-wrapper > header > div.header-top > div > div.header-left.header-dropdowns.clsMobTop > p.welcome-msg1.clsTopContact > a");
    private final By logoutButton = By.cssSelector("body > div.page-wrapper > header > div.header-top > div > div.header-right > p:nth-child(2) > a");

    @Step("navigate to register page")
    public RegisterPage navigateToRegisterPage() {
        driver.element().click(accountManagerIcon);
        driver.element().click(signUpButton);


        return  new RegisterPage(driver);
    }

    @Step("navigate tp contact us page")
    public ContactUsPage navigateToContactUs() {
        driver.element().click(ContactUsPage);
        return new ContactUsPage(driver);
    }

    public void logout(){
        driver.element().click(logoutButton);
    }


    public LoginPage navigateToLoginPage(){
        driver.element().click(accountManagerIcon);
        return new LoginPage(driver);
    }
}
