package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class RegisterPage {
    SHAFT.GUI.WebDriver driver;


    public RegisterPage (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }


    private final By firstNameTxt = By.id("registerfirst");
    private final By lastNameTxt = By.id("registerlast");
    private final By emailTxt = By.id("registeremail");
    private final By passwordTxt = By.id("registerpassword");
    private final By genderButton = By.xpath("//input[@value='male']");
    private final By AssertionMessage = By.xpath("//p[text()='First Name : Mahmoud']");

    public void enterRegisterData (String firstName,String lastName,String email, String password
    ) throws InterruptedException {
        driver.element().type(firstNameTxt,firstName);
        driver.element().type(lastNameTxt,lastName);
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(genderButton);

    }

    public String getAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }
}
