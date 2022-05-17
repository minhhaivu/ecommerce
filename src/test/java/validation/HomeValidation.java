package validation;

import org.testng.Assert;
import pages.HomePage;

public class HomeValidation {

    public void checkCartQuantity(Integer cartQuantity) {
        HomePage homePage = new HomePage();
        Assert.assertEquals(homePage.getCartQuantity(), cartQuantity.toString());
    }
}
