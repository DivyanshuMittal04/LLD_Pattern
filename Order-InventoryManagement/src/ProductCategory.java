import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductCategory {
    int id = 0;
    String name;
    List<Product>productList;
    double price;

    public ProductCategory(String name, double price) {
        this.id += 1;
        this.name = name;
        this.price = price;
        productList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addProduct(Product product){
        productList.add(product);
    }

    public void removeProduct(int id){
        for(Product product : productList){
            if(product.getId() == id){
                productList.remove(product);
                return;
            }
        }
    }

    public Product getProduct(int id){
        return productList.stream().filter(p -> Objects.equals(p.getId(),id)).findFirst().orElse(null);
    }
}
