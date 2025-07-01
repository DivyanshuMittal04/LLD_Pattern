import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategory> productCategories) {
        this.productCategories = productCategories;
    }

    List<ProductCategory> productCategories;

    public Inventory() {
        productCategories = new ArrayList<>();
    }

    public void addToInventory(String name, double price){
        ProductCategory productCategory = new ProductCategory(name,price);
        productCategories.add(productCategory);
    }

    public void addProduct(Product product, int productCategoryId){

        //take out the respective productCategory Object
        ProductCategory categoryObject = null;
        for(ProductCategory category : productCategories)
        {
            if(category.getId() == productCategoryId){
                categoryObject = category;
            }
        }

        if(categoryObject !=null) {
            categoryObject.addProduct(product);
        }
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){

        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            if (category != null) {
                category.removeProduct(entry.getValue());
            }
        }

    }

    public void addItems(Map<Integer, Integer> productCategoryAndCountMap){

        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            if (category != null) {
                Product product = category.getProduct(category.getId());
                category.addProduct(product);
            }
        }

    }

    private ProductCategory getProductCategoryFromID(int productCategoryId){

        for(ProductCategory productCategory : productCategories){

            if(productCategory.getId() == productCategoryId){
                return productCategory;
            }
        }

        return null;
    }


}
