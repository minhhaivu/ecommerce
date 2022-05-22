package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import validation.CheckOutValidation;
import validation.HomeValidation;

import java.util.Random;

public class QuickAddToEmptyCartTest {

    @Test
    public void quickAddToEmptyCart() {
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
