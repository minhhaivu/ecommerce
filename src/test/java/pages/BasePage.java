package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends AbstractPage {
    @FindBy(className = "login")
    private WebElement signInBtn;

    @FindBy(id = "search_query_top")
    private WebElement searchTxt;

    @FindBy(name = "submit_search")
    private WebElement searchBtn;

    @FindBy(className = "ajax_cart_quantity")
    private WebElement cartQuantitySpn;

    private final String HOME_URL = "http://automationpractice.com/index.php";

    public BasePage() {
        super();
    }

    public BasePage open() {

        pageDriver.get(HOME_URL);
        System.out.println(pageDriver.getTitle() + " page is opened.");

        return this;
    }

    public BasePage clickSignIn() {
        signInBtn.click();
        System.out.println(pageDriver.getTitle() + " page is opened.");

        return this;
    }

    public BasePage search(String searchString) {
        searchTxt.sendKeys(searchString);
        searchBtn.click();

        return this;
    }

    public Integer getCartQuantity() {
        String cartQuantity = cartQuantitySpn.getText();
        if (cartQuantity.isEmpty()) {
            System.out.println("Cart is Empty.");
            return 0;
        } else {
            System.out.println("Number of products in the cart: " + cartQuantitySpn.getText());
            return Integer.valueOf(cartQuantitySpn.getText());
        }
    }

}
