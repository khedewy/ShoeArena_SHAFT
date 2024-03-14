package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    SHAFT.TestData.JSON registerData;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    @Step("navigate to create account page")
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }
    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        registerPage = new RegisterPage(driver);
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");

        registerPage.enterRegisterData(
                registerData.getTestData("firstName"), registerData.getTestData("lastName"),
                registerData.getTestData("email")+currentTime+"@gmail.com", registerData.getTestData("password"));

        Assert.assertEquals(registerPage.getAssertionMessage(),"First Name : Mahmoud");

    }
}
