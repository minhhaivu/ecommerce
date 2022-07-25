package test;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.SearchPage;
import validation.SearchValidation;

@Listeners(listeners.CustomizedEmailableReporter.class)
public class ValidSearchTest extends BaseTest {
    @Test(groups = {"PS"})
    public void verifyIfSearchResultsReturn() {
        SearchPage searchPage = new SearchPage();

        Reporter.log("Verify items quantity found equal item quantity showed.");
        Reporter.log("Verify items found matching the search");
        SearchValidation.checkItemQuantityFound(searchPage.getItemQuantityFound(),
                searchPage.getProductList().size());
        SearchValidation.checkItemsFoundContain(searchPage.getItemListFoundByName(), "Dress");
    }

    @Test(groups = {"PS"})
    public void openSearchPage() {

        Reporter.log("Step 1: Launch My Store page");
        BasePage basePage = new BasePage();

        Reporter.log("Step 2: Enter a value into Search textbox");
        basePage.open().search("Dress");
    }

    @Test(groups = {"PS"},
            dependsOnMethods = {"openSearchPage","verifyIfSearchResultsReturn"},
            alwaysRun = true)
    public void closeSearchPage() {
        SearchPage searchPage = new SearchPage();
        searchPage.close();
    }
}
