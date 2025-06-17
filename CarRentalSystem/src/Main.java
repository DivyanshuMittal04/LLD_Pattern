import Product.Car;
import Product.Status;
import Product.Vehicle;
import Product.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        Location location = new Location("HSR", "Bangalore", "Karnataka", 560102);
        List<Store> stores = addStores(vehicles,location);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(users,stores);

        //0. User comes
        User user = users.getFirst();

        //1. user search store based on location
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        Vehicle selectedVehicle = storeVehicles.getFirst();

        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(selectedVehicle, users.get(0), LocalDateTime.of(2025, 6,16,16, 0),LocalDateTime.of(2025,6,16,18,0));

        //4. generate the bill
        Bill bill = new Bill(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(PaymentMode.CASH,bill.getAmount(),bill);

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(selectedVehicle);

    }



    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car(1,"1706", Status.ACTIVE,0,0,0,0,4,10,10);

        Vehicle vehicle2 = new Car(2,"1707", Status.ACTIVE,0,0,0,0,4,10,10);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User("123456789","Divyanshu");

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles, Location location){

        List<Store> stores = new ArrayList<>();
        Store store1 = new Store(1,location);
        vehicles.forEach(store1::addVehicle);
        stores.add(store1);
        return stores;
    }

    }