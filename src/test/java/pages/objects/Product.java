package pages.objects;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {
    private String name;
    private String price;
}
