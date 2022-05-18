package test;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import validation.SearchValidation;

@Test
public class ValidSearchTest {
    public void validSearch() {
        String searchItem = "Dress";
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();

        homePage.open().search(searchItem);
        SearchValidation.checkItemQuantityFound(searchPage.getItemQuantityFound(),
                searchPage.getProductList().size());
        SearchValidation.checkItemsFoundContain(searchPage.getItemListFoundByName(), searchItem);

        searchPage.close();
    }
}
