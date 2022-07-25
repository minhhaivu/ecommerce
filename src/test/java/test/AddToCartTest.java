package test;

import org.testng.Assert;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import pages.objects.Cart;
import pages.objects.Product;

@Listeners(listeners.CustomizedEmailableReporter.class)
public class AddToCartTest {

    @Test(groups={"ST"},priority = 1,attributes = {@CustomAttribute(name = "priority",values = "")})
    public void addToCart() {
        System.out.println("Add To Cart with given quantity, size & color");
        BasePage basePage = new BasePage();
        SearchPage searchPage = new SearchPage();
        AddToCartPage addToCartPage = new AddToCartPage();
        ProductInfoPage productInfoPage = new ProductInfoPage();

        basePage.open().search("dress");
        searchPage.selectRandomProduct();
        productInfoPage.enterProductInfoAddToCart("M", 2);
        Product expectedProduct = productInfoPage.getAddedProduct();
        expectedProduct.setTotalPrice();
        productInfoPage.addToCart();

        float total = Float.parseFloat(expectedProduct.getTotal().substring(1)) + (float) 2.00;
        Cart expectedCart = Cart.builder().totalProducts(expectedProduct.getTotal())
                .totalShipping("$2.00").total("$" + total).build();

        Assert.assertEquals(addToCartPage.getSuccessfulAddedMessage(),
                "Product successfully added to your shopping cart");
        Assert.assertEquals(addToCartPage.getCartProductLbl().getText(),
                "There are 2 items in your cart.");
        addToCartPage.getAddedProduct().equal(expectedProduct);
        addToCartPage.getCartInfo().equal(expectedCart);
    }
}
