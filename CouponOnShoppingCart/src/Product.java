public abstract class Product {
    String name;

    Product(){};
    public ProductType getType() {
        return type;
    }

    ProductType type;
    double actualPrice;

    public Product(String name, ProductType type, double actualPrice) {
        this.name = name;
        this.type = type;
        this.actualPrice = actualPrice;
    }

    public abstract double getPrice();
}
