package validation;

import org.testng.Assert;

public class BaseValidation {
    public static void checkStringArrayElementContain(String[] strings, String string, String message) {
        for (String item : strings
        ) {
            Assert.assertTrue(item.contains(string), message);
        }
    }
}
