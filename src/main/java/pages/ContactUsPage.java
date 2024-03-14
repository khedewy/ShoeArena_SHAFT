package pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;




public class ContactUsPage {
    SHAFT.GUI.WebDriver driver;

    public ContactUsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By mobileTxt = By.id("contact-mobile");
    private final By subjectList = By.id("contact-subject");
    private final By messageTxt = By.id("contact-enquiry");
    private final By submitButton = By.name("submit");


    @Step("enter contact us data")
    public void enterContactUsData(String mobile, String subject,String message)  {

        driver.element().type(mobileTxt,mobile);
        driver.element().select(subjectList,subject);
        driver.element().type(messageTxt,message);
        driver.element().click(submitButton);
    }
    
}
