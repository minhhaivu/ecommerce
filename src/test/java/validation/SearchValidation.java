package validation;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.List;

@Test
public class SearchValidation {
    public void checkSearchResultDetail(String searchString) {
        SearchPage searchPage = new SearchPage();
        List<WebElement> searchResult = searchPage.getProductList();
        for (WebElement item : searchResult
        ) {
            if (!item.getText().contains(searchString)) {
                System.out.println("Product Name is" + item.getText() + " while user wants to search " + searchString);
            }
            Assert.assertTrue(item.getText().contains(searchString));
        }
    }

    public void checkSearchResultCountMsg() {
        SearchPage searchPage = new SearchPage();
        Assert.assertTrue(searchPage.getSearchResultCountMsg()
                .contains(" results have been found."));
    }
}
