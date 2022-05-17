package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends AbstractPage {
    @FindBy(xpath = "//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;

    public AddToCartPage() {
        super();
    }

    public AddToCartPage proceedToCheckout() {
        proceedToCheckoutBtn.click();
        return this;
    }

}
