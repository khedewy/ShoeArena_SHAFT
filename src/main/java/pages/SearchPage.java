package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


import java.awt.*;
import java.awt.event.KeyEvent;


public class SearchPage {
    SHAFT.GUI.WebDriver driver;
    Robot robot;

    public SearchPage(SHAFT.GUI.WebDriver driver){
        this.driver= driver;
    }

    private final By searchBox = By.id("search-box");
    private final By firstProduct = By.xpath("//a[@title='Adidas Men Sport Shoes Dark Gray']");

    public void searchForItems(String product) throws  AWTException {
        driver.element().type(searchBox,product);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        driver.element().click(firstProduct);
    }
}
