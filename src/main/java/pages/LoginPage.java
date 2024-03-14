package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class LoginPage {
    SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = By.id("notifyemail");
    private final By passwordTxt = By.id("notifypassword");
    private final By submitButton = By.id("submit");
    private final By AssertionMessage = By.xpath("//p[text()='First Name : Mahmoud']");

    public void enterLoginData(String email, String password){
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(submitButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }
}
