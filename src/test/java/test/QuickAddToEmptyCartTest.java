package test;

import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchPage;
import validation.CheckOutValidation;
import validation.HomeValidation;

public class QuickAddToEmptyCartTest {

    @Test
    public void addToEmptyCart() {
        String searchStr = "dress";

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        AddToCartPage addToCartPage = new AddToCartPage();
        CheckOutPage checkOutPage = new CheckOutPage();

        homePage.open().search(searchStr);
        searchPage.quickAddToCartByIndex(1);
        addToCartPage.proceedToCheckout();
        HomeValidation.checkCartQuantity(homePage.getCartQuantity(), 1);
        CheckOutValidation.checkOutPageOpened();

        checkOutPage.close();
    }
}
