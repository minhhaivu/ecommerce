package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage extends AbstractPage {
    @FindBy(xpath = "//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;

    public AddToCartPage() {
        super();
    }

    public AddToCartPage proceedToCheckout() {
        new WebDriverWait(pageDriver, TIME_OUT_IN_SECOND)
                .until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();
        return this;
    }

}
