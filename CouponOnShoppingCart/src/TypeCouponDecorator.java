import java.util.ArrayList;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator {

    Product product;
    int discountPercentage;
    ProductType productType;
    static List<ProductType> eligibleProductTypes = new ArrayList<>(List.of(new ProductType[]{ProductType.FURNITURE}));
    public TypeCouponDecorator(Product product, int percentage, ProductType type) {
        this.product = product;
        this.discountPercentage = percentage;
        this.productType = type;
    }

    @Override
    public double getPrice() {
        if(eligibleProductTypes.contains(productType))
           return product.getPrice()*(100-discountPercentage)*0.01;
        return product.getPrice();
    }
}
