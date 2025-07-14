public class PercentageCouponDecorator extends CouponDecorator{
    Product product;
    int percentage;
    public PercentageCouponDecorator(Product product, int percentage) {
        this.product = product;
        this.percentage = percentage;
    }

    @Override
    public double getPrice() {
        return product.getPrice()*(100 - percentage)*0.01;
    }
}
