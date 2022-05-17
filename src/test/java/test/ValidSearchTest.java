package test;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import validation.SearchValidation;

@Test
public class ValidSearchTest {
    public void validSearch() {
        String searchString = "Dress";
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        SearchValidation searchValidation = new SearchValidation();

        homePage.open().search(searchString);
        searchValidation.checkSearchResultCountMsg();
        searchValidation.checkSearchResultDetail(searchString);

        searchPage.close();
    }
}
