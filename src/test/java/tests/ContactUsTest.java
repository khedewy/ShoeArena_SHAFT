package tests;

import com.shaft.driver.SHAFT;

import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class ContactUsTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    ContactUsPage contactUsPage;
    SHAFT.TestData.JSON registerData;
    SHAFT.TestData.JSON contactUsData;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    @Step("navigate to create account page")
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }
    @Test(priority = 1)
    @Step("enter register data")
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        registerPage = new RegisterPage(driver);
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");

        registerPage.enterRegisterData(
                registerData.getTestData("firstName"), registerData.getTestData("lastName"),
                registerData.getTestData("email")+currentTime+"@gmail.com", registerData.getTestData("password"));

        Assert.assertEquals(registerPage.getAssertionMessage(),"First Name : Mahmoud");

    }

    @Test(priority = 2)
    @Step("navigate to contact us page")
    public void navigateToContactUsPage()  {
        homePage = new HomePage(driver);
        homePage.navigateToContactUs();
    }

    @Test(priority = 3)
    @Step("enter contact us data")
    public void contactUs(){
        contactUsPage = new ContactUsPage(driver);
        contactUsData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/contactUsData.json");
        contactUsPage.enterContactUsData(contactUsData.getTestData("mobile"),
                contactUsData.getTestData("subject"),contactUsData.getTestData("message"));
    }
}
