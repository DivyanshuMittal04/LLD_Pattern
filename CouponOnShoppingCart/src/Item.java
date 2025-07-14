public class Item extends Product{
    public Item(String name, ProductType type, double actualPrice) {
        super(name, type, actualPrice);
    }

    @Override
    public double getPrice() {
        return actualPrice;
    }
}
