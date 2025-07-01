import java.util.*;

public class OrderController {
    List<Order>orderList;
    Map<Integer, List<Order>> userIDVsOrders;

    OrderController(){
        orderList = new ArrayList<>();
        userIDVsOrders = new HashMap<>();
    }


    public Order createNewOrder(User user, Warehouse warehouse){
        Order order = new Order(user, warehouse);
        orderList.add(order);

        if(userIDVsOrders.containsKey(user.getId())){
            List<Order> userOrders = userIDVsOrders.get(user.getId());
            userOrders.add(order);
            userIDVsOrders.put(user.getId(), userOrders);
        } else {
            List<Order> userOrders = new ArrayList<>();
            userOrders.add(order);
            userIDVsOrders.put(user.getId(), userOrders);

        }
        return order;
    }

    public void removeOrder(Order order){
        orderList.remove(order);
    }

    public List<Order> getOrderByCustomerId(int userId){
        return userIDVsOrders.get(userId);
    }

    public Order getOrderByOrderId(int orderId){
        return orderList.stream().filter(o ->
                    Objects.equals(o.getId(),orderId)
        ).findFirst()
                .orElse(null);
    }


}
