package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

@Getter
public class SearchPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='product-container']//a[@class='product-name']")
    private List<WebElement> productList;

    @FindBy(className = "heading-counter")
    private WebElement searchResultCounterLbl;

    private WebElement getQuickAddToCartButtonByIndex(Integer index) {
        return pageDriver.findElement(By.xpath("(//a[@title = 'Add to cart'])["
                + index + "]"));
    }

    private WebElement getProductNameLinkByIndex(Integer index) {
        return pageDriver.findElement(By.xpath("(//div[@class='product-container'])[" + index + "]//h5/a"));
    }

    private WebElement getProductInfoContainerByIndex(Integer index) {
        return pageDriver.findElement(By.xpath("(//div[@class='product-container'])[" + index + "]"));
    }

    public SearchPage() {
        super();
    }

    public Integer getItemQuantityFound() {
        String searchResultMsg = searchResultCounterLbl.getText();
        String searchResultQuantity = searchResultMsg.substring(0, searchResultMsg.indexOf("results", 1) - 1);
        System.out.println("Item quantity found: " + searchResultQuantity);
        return Integer.valueOf(searchResultQuantity);
    }

    public String[] getItemListFoundByName() {
        String[] itemList = new String[productList.size()];
        System.out.println("List of items found:");
        for (int i = 0; i < productList.size(); i++) {
            itemList[i] = productList.get(i).getText();
            System.out.println(" - " + itemList[i]);
        }
        return itemList;
    }

    public SearchPage quickAddToCart(Integer productIndex) {
        hoverMouse(getProductInfoContainerByIndex(productIndex));
        getQuickAddToCartButtonByIndex(productIndex).click();
        return this;
    }

    public SearchPage selectRandomProduct() {
        Integer productIndex = new Random().nextInt(getItemQuantityFound()) + 1;
        scrollInToView(getProductInfoContainerByIndex(productIndex));
        getProductNameLinkByIndex(productIndex).click();
        return this;
    }
}
