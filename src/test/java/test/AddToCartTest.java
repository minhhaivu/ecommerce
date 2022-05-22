package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.objects.Cart;
import pages.objects.Product;

public class AddToCartTest {

    @Test
    public void addToCart() {
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        AddToCartPage addToCartPage = new AddToCartPage();
        ProductInfoPage productInfoPage = new ProductInfoPage();

        homePage.open().search("dress");
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
