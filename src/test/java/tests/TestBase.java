package tests;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {
    protected static SHAFT.GUI.WebDriver driver;

    @BeforeClass
    public void setDriver(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://www.shoearena.sa/en");
    }

    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
