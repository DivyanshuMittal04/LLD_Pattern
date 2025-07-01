import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args){
            Main mainObj = new Main();

            //1. create warehouses in the system
            List<Warehouse> warehouseList = new ArrayList<>();
            warehouseList.add(mainObj.addWarehouseAndItsInventory());

            //2. create users in the system
            List<User> userList = new ArrayList<>();
            userList.add(mainObj.createUser());

            //3. feed the system with the initial informations
            ProductDeliverySystem productDeliverySystem = new ProductDeliverySystem(userList, warehouseList);


            mainObj.runDeliveryFlow(productDeliverySystem, 1);
        }



        private Warehouse addWarehouseAndItsInventory(){


            Inventory inventory = new Inventory();

            inventory.addToInventory( "Pepsi Large Cold Drink" , 100);
            inventory.addToInventory( "Dove small Soap" , 50);

            //CREATE 3 Products

            Product product1 = new Product("Pepsi");

            Product product2 = new Product("Pepsi");

            Product product3 = new Product("Dove");


            inventory.addProduct(product1, product1.getId());
            inventory.addProduct(product2, product1.getId());
            inventory.addProduct(product3, product3.getId());
            return new Warehouse(inventory, new Address("230011","abc","def"));
        }


        private User createUser(){
            User user = new User("Divyanshu",new Address("230011", "city", "state"));
            return user;
        }

        private void runDeliveryFlow(ProductDeliverySystem productDeliverySystem, int userId){


            //1. Get the user object
            User user = productDeliverySystem.getUser(userId);

            //2. get warehouse based on user preference
            Warehouse warehouse = productDeliverySystem.getWarehouse(new NearestWarehouseSelectionStrategy());

            //3. get all the inventory to show the user
            Inventory inventory = productDeliverySystem.getInventory(warehouse);

            ProductCategory productCategoryIWantToOrder = null;
            for(ProductCategory productCategory : inventory.getProductCategories()){

                if(productCategory.getName().equals("Pepsi Large Cold Drink")){
                    productCategoryIWantToOrder = productCategory;
                }
            }


            //4. add product to the cart
            productDeliverySystem.addProductToCart(user, productCategoryIWantToOrder, 2);


            //4. place order
            Order order = productDeliverySystem.placeOrder(user, warehouse);


            //5. checkout
            productDeliverySystem.checkout(order);

        }
}