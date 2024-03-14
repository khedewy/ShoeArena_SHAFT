package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;




public class AddToCartPage {
    SHAFT.GUI.WebDriver driver;
    public AddToCartPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By size = By.xpath("//li[@data-eu='43.5']");
    private final By addToCartButton = By.id("button-cart");
    private final By viewCartButton = By.xpath("//button[text()=\"View Cart\"]");
    private final By AssertionMessage = By.xpath("//a[text()=\"Adidas Men Sport Shoes Dark Gray\"]");

    public void addProductToCart(){
        driver.element().click(size);
        driver.element().click(addToCartButton);
        driver.element().click(viewCartButton);
    }

    public String getAssertionMessage(){

        return driver.element().getText(AssertionMessage);
    }
}
