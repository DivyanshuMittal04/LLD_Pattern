//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Product product = new Item("ABC",ProductType.FURNITURE,100);
        Product product1 = new Item("DEF",ProductType.ELECTRONICS,200);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product1);
        System.out.println("Total Price after discount is " + shoppingCart.getTotalPrice());
    }
}