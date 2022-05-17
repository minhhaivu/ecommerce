package test;

import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchPage;
import pages.objects.Product;
import validation.CheckOutValidation;
import validation.HomeValidation;

public class QuickAddToCartTest {

    @Test
    public void addToCart() {
        String searchStr = "dress";
        String productName = "Printed Summer Dress";
        String productPrice = "$28.98";
        Product product = Product.builder().name(productName).price(productPrice).build();

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        AddToCartPage addToCartPage = new AddToCartPage();
        HomeValidation homeValidation = new HomeValidation();
        CheckOutValidation checkOutValidation = new CheckOutValidation();

        homePage.open().search(searchStr);
        Integer preQuantity = homePage.getCartQuantity();
        searchPage.quickAddToCart(product);
        addToCartPage.proceedToCheckout();
        homeValidation.checkCartQuantity(preQuantity + 1);
        checkOutValidation.checkOutPageOpened();

    }
}
