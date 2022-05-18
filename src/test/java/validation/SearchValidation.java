package validation;

import org.testng.Assert;

public class SearchValidation {
    public static void checkItemsFoundContain(String[] itemFound, String searchItem) {
        BaseValidation.checkStringArrayElementContain(itemFound, searchItem, "Item found does not contain search item - " + searchItem);
    }

    public static void checkItemQuantityFound(Integer actualNumber, Integer expectedNumber) {
        Assert.assertEquals(actualNumber, expectedNumber);
    }
}
