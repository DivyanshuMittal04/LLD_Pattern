import java.util.Map;

public class Order {
    User user;
    Address address;
    Map<Integer, Integer>categoryVsCount;
    Warehouse warehouse;
    Payment payment;
    Status status;
    Invoice invoice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id = 0;


    Order(User user, Warehouse warehouse){
        this.user = user;
        this.categoryVsCount = user.getCart().getCartItems();
        this.warehouse = warehouse;
        this.address = user.getAddress();
        invoice = new Invoice();
        invoice.generateInvoice(this);
        id += 1;
    }

    public void checkOut(){
        warehouse.removeItemFromInventory(categoryVsCount);
        boolean isPaymentSuccess = new Payment(PaymentMode.CASH).isPaymentSuccess();
        if(isPaymentSuccess) {
            user.getCart().emptyCart();
        }
        else{
            warehouse.addItemToInventory(categoryVsCount);
        }
    }
}
