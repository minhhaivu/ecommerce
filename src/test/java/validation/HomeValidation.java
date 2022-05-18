package validation;

import org.testng.Assert;

public class HomeValidation {

    public static void checkCartQuantity(Integer actualQuantity, Integer expectedQuantity) {
        Assert.assertEquals(actualQuantity, expectedQuantity);
    }
}
