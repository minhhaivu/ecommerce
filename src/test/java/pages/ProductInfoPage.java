package pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.objects.Product;

import java.util.List;
import java.util.Random;

@Getter
public class ProductInfoPage extends AbstractPage {
    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productNameLbl;

    @FindBy(id = "our_price_display")
    private WebElement productPriceLbl;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityTxt;

    @FindBy(id = "group_1")
    private WebElement sizeCbb;

    @FindBy(id = "color_to_pick_list")
    private List<WebElement> colorList;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']/li[@class='selected']")
    private WebElement selectedColor;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCartBtn;

    private WebElement colorBtnByIndex(Integer index) {
        return pageDriver.findElement(By.xpath("//ul[@id='color_to_pick_list']/li" + "[" + index + "]/a"));
    }

    public ProductInfoPage() {
        super();
    }

    private ProductInfoPage enterProductQuantity(Integer quantity) {
        new Actions(pageDriver).doubleClick(quantityTxt).perform();
        quantityTxt.sendKeys(quantity.toString());
        return this;
    }

    public ProductInfoPage selectProductSize(String productSize) {
        Select size = new Select(sizeCbb);
        size.selectByVisibleText(productSize);
        return this;
    }

    public String getProductName() {
        return productNameLbl.getText();
    }

    public ProductInfoPage enterProductInfoAddToCart(String productSize, Integer productQuantity) {
        Integer randomColorIndex = new Random().nextInt(colorList.size()) + 1;
        enterProductQuantity(productQuantity);
        selectProductSize(productSize);
        colorBtnByIndex(randomColorIndex).click();
        return this;
    }

    public ProductInfoPage addToCart() {
        addToCartBtn.click();
        new WebDriverWait(pageDriver, 10)
                .until(ExpectedConditions.attributeContains(addToCartBtn, "class", "added"));
        return this;
    }

    public Product getAddedProduct() {
        new WebDriverWait(pageDriver, 5).until(ExpectedConditions.visibilityOf(selectedColor));
        return Product.builder().name(getProductName()).color(selectedColor.getAttribute("title"))
                .size(getSizeCbb().getText()).quantity(Integer.parseInt(getQuantityTxt().getAttribute("value")))
                .price(getProductPriceLbl().getText()).build();
    }
}