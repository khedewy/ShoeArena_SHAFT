package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.SearchPage;

import java.awt.*;

public class AddToCartTest extends TestBase{
    SearchPage searchPage;
    AddToCartPage add;

    @Test
    public void searchForProducts() throws AWTException {
        searchPage = new SearchPage(driver);
        searchPage.searchForItems("Adidas Men Sport Shoes Dark Gray");
    }

    @Test(priority = 1)
    public void addProductToCart() {
        add = new AddToCartPage(driver);
        add.addProductToCart();
        Assert.assertEquals(add.getAssertionMessage(),"Adidas Men Sport Shoes Dark Gray");
    }
}
