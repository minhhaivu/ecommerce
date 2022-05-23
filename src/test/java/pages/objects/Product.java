package pages.objects;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private String name;
    private String price;
    private String size;
    private String color;
    private Integer quantity;
    private String total;

    public Boolean equal(Product product) {
        if (product == null)
            return false;
        if (product == this)
            return true;
        return (this.name == product.name) && (this.price == product.price)
                && (this.size == product.size) && (this.color == product.color)
                && (this.quantity == product.quantity) && (this.total == product.total);
    }

    public void setTotalPrice() {
        total = "$" + Float.parseFloat(price.substring(1)) * quantity;
    }
}
