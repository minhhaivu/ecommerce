package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import validation.CheckOutValidation;
import validation.HomeValidation;

@Listeners(listeners.CustomizedEmailableReporter.class)
public class QuickAddToEmptyCartTest {
    @Test(groups={"PS"})
    public void quickAddToEmptyCart() {
        String searchStr = "dress";

        System.out.println("Quick Add to cart with default color, size");
        BasePage basePage = new BasePage();
        SearchPage searchPage = new SearchPage();
        AddToCartPage addToCartPage = new AddToCartPage();

        basePage.open().search(searchStr);
        searchPage.quickAddToCart(1);
        addToCartPage.proceedToCheckout();
        HomeValidation.checkCartQuantity(basePage.getCartQuantity(), 1);
        CheckOutValidation.checkOutPageOpened();

        basePage.close();
    }
}
