import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    int id = 0;
    Address address;
    Cart cart;
    List<String>orderId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<String> orderId) {
        this.orderId = orderId;
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
        orderId = new ArrayList<>();
        cart = new Cart();
        id += 1;
    }
}
