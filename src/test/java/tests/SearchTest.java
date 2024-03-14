package tests;

import org.testng.annotations.Test;
import pages.SearchPage;

import java.awt.*;

public class SearchTest extends TestBase{
    SearchPage searchPage;

    @Test
    public void searchForProducts() throws  AWTException {
        searchPage = new SearchPage(driver);
        searchPage.searchForItems("Adidas Men Sport Shoes Dark Gray");

    }
}
