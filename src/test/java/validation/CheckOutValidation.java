package validation;

import org.testng.Assert;
import pages.CheckOutPage;

public class CheckOutValidation {

    public static void checkOutPageOpened() {
        CheckOutPage checkOutPage = new CheckOutPage();
        String checkOutPageTitle = checkOutPage.getPageDriver().getTitle();
        Assert.assertEquals(checkOutPageTitle, "Order - My Store",
                "CheckOut page is not opened OR its title is changed.");
    }
}
