import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer, Integer> categoryIdVsCount;

    public Cart() {
        categoryIdVsCount = new HashMap<>();
    }

    public void addToCart(int productCategoryId, int count){
        if(categoryIdVsCount.containsKey(productCategoryId)){
            int noOfItemsInCart = categoryIdVsCount.get(productCategoryId);
            categoryIdVsCount.put(productCategoryId, noOfItemsInCart + count);
        } else{
            categoryIdVsCount.put(productCategoryId, count);
        }
    }

    public void removeFromCart(int productCategoryId, int count){
        if (categoryIdVsCount.containsKey(productCategoryId))
        {
            int noOfItemsInCart = categoryIdVsCount.get(productCategoryId);
            if (count - noOfItemsInCart <= 0) {
                categoryIdVsCount.remove(productCategoryId);
            } else {
                categoryIdVsCount.put(productCategoryId, noOfItemsInCart - count);
            }
        }
    }

    public  Map<Integer, Integer> getCartItems(){
        return categoryIdVsCount;
    }

    public void emptyCart(){
        categoryIdVsCount = new HashMap<>();
    }

}
