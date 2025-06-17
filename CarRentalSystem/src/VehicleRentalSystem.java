import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class VehicleRentalSystem {
    List<User>users;
    List<Store>stores;

    public VehicleRentalSystem(List<User> users, List<Store> stores) {
        this.users = users;
        this.stores = stores;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public void addStore(Store store){
        stores.add(store);
    }

    public void removeStore(Store store){
        stores.remove(store);
    }

    public Store getStore(Location location){
        return stores.stream().filter(s-> s!=null && Objects.equals(s.getLocation(),location)).findFirst().get();
    }


}
