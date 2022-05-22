package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.objects.Cart;
import pages.objects.Product;

@Getter
public class AddToCartPage extends AbstractPage {
    @FindBy(xpath = "//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;

    @FindBy(xpath = "//*[@id='layer_cart']//span[@title='Close window']/following-sibling::h2")
    private WebElement successfulAddedLbl;

    @FindBy(id = "layer_cart_product_quantity")
    private WebElement productQuantityLbl;

    @FindBy(id = "layer_cart_product_price")
    private WebElement totalProductPriceLbl;

    @FindBy(id = "layer_cart_product_title")
    private WebElement productNameLbl;

    @FindBy(id = "layer_cart_product_attributes")
    private WebElement productAttributesLbl;

    @FindBy(xpath = "//span[@class='ajax_cart_product_txt_s  unvisible']")
    private WebElement cartProductLbl;

    @FindBy(xpath = "//span[@class='ajax_block_products_total']")
    private WebElement totalProductsVl;

    @FindBy(xpath = "//span[@class='ajax_cart_shipping_cost']")
    private WebElement totalShippingVl;

    @FindBy(xpath = "//span[@class='ajax_block_cart_total']")
    private WebElement totalVl;

    public AddToCartPage() {
        super();
    }

    public String getSuccessfulAddedMessage() {
        new WebDriverWait(getPageDriver(), 3000).until(ExpectedConditions
                .visibilityOf(getSuccessfulAddedLbl()));
        return getSuccessfulAddedLbl().getText();
    }

    public AddToCartPage proceedToCheckout() {
        new WebDriverWait(pageDriver, TIME_OUT_IN_SECOND)
                .until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn));
        proceedToCheckoutBtn.click();
        return this;
    }

    public Product getAddedProduct() {
        return Product.builder().name(productNameLbl.getText()).color(getProductColor())
                .size(getProductSize()).quantity(Integer.parseInt(getProductQuantityLbl().getText()))
                .price(getProductPrice()).build();
    }

    public String getProductPrice() {
        float productPrice = Float.parseFloat(totalProductPriceLbl.getText().substring(1)) / Integer.parseInt(productQuantityLbl.getText());
        return "$" + productPrice;
    }

    public String getProductColor() {
        return productAttributesLbl.getText().substring(0, productAttributesLbl.getText().indexOf(",") - 1);
    }

    public String getProductSize() {
        return productAttributesLbl.getText().substring(productAttributesLbl.getText().indexOf(",") + 1);
    }

    public Cart getCartInfo() {
        return Cart.builder().totalProducts(totalProductsVl.getText())
                .totalShipping(totalShippingVl.getText())
                .total(totalVl.getText()).build();
    }
}
