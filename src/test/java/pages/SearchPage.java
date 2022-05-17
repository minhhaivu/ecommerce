package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.objects.Product;

import java.util.List;

@Getter
public class SearchPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='product-container']//a[@class='product-name']")
    private List<WebElement> productList;

    @FindBy(className = "heading-counter")
    private WebElement searchResultCountLbl;

    private WebElement productLocator(Product product) {
        return pageDriver.findElement(By.xpath("//div[@class='product-container' and .//a[contains(text(),'"
                + product.getName() + "')] and .//span[contains(text(),'" + product.getPrice() + "')]]"));
    }

    private WebElement addToCartLocator(Product product) {
        return pageDriver.findElement(By.xpath("//a[@title = 'Add to cart']//ancestor::div[@class='product-container' and .//a[contains(text(),'"
                + product.getName() + "')] and .//span[contains(text(),'" + product.getPrice() + "')]]"));
    }

    public SearchPage() {
        super();
    }

    public String getSearchResultCountMsg() {
        return searchResultCountLbl.getText();
    }

    public SearchPage quickAddToCart(Product product) {
        Actions action = new Actions(pageDriver);
        action.moveToElement(productLocator(product));
        addToCartLocator(product).click();

        return this;
    }
}
