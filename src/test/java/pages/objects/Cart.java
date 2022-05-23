package pages.objects;

import lombok.Builder;

@Builder
public class Cart {
    String totalProducts;
    String totalShipping;
    String total;

    public Boolean equal(Cart cart) {
        if (cart==null)
            return false;
        if (this==cart)
            return true;
        return (this.totalProducts==cart.totalProducts)&&(this.totalShipping==cart.totalShipping)
                &&(this.total== cart.total);
    }
}
