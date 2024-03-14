package tests;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase{
    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    SHAFT.TestData.JSON registerData;
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
    @Step("logout And ChangeLanguage Into English")
    public void logout(){
        homePage = new HomePage(driver);
        homePage.logout();

    }

    @Test(priority = 3)
    @Step("navigate to login page to log with existing data")
    public void navigateToLoginPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToLoginPage();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    @Step("enter log data that is used to register")
    public void enterLoginData()  {
        loginPage = new LoginPage(driver);
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        loginPage.enterLoginData(registerData.getTestData("email")+currentTime+"@gmail.com", registerData.getTestData("password"));
        Assert.assertEquals(loginPage.getAssertionMessage(),"First Name : Mahmoud");
    }
}
