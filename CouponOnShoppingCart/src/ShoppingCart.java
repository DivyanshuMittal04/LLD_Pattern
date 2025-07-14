import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        Product finalProduct = new TypeCouponDecorator(new PercentageCouponDecorator(product,10),10,product.getType());
        productList.add(finalProduct);
    }

    public int getTotalPrice(){
        int totalCost = 0;
        for(Product product: productList){
            totalCost += product.getPrice();
        }
        return totalCost;
    }
}
