import Product.Status;
import Product.Vehicle;
import Product.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Store {
    int id;

    public Store(int id, Location location) {
        this.id = id;
        this.location = location;
        this.vehicleInventoryManagement = new VehicleInventoryManagement();
        this.reservationList = new ArrayList<>();
    }

    public List<Vehicle>getVehicles(VehicleType vehicleType){
        return vehicleInventoryManagement.getVehicles(vehicleType);
    }

    public void addVehicle(Vehicle vehicle){
        vehicleInventoryManagement.addVehicle(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        vehicleInventoryManagement.removeVehicle(vehicle);
    }

    public Reservation createReservation(Vehicle vehicle, User user, LocalDateTime bookedFrom, LocalDateTime bookedTo){
        if(vehicle.getStatus() == Status.INACTIVE){
            System.out.println("Vehicle is inactive and not ready for reservation");
            return null;
        }
        Reservation reservation = new Reservation(user,vehicle,bookedFrom,bookedTo);
        reservationList.add(reservation);
        vehicle.setStatus(Status.INACTIVE);
        return reservation;
    }

    public void completeReservation(Vehicle vehicle){
        Optional<Reservation> reservation = reservationList.stream()
                .filter(r -> r != null && Objects.equals(r.getVehicle(), vehicle))
                .findFirst();
        if(reservation.isEmpty()){
            System.out.println("No Reservation Found for Vehicle :- " + vehicle.getNumber());
            return;
        }
        System.out.println("Reservation Found for Vehicle :- " + vehicle.getNumber() + " and is completed");
        reservationList.remove(reservation.get());
        vehicle.setStatus(Status.ACTIVE);
    }

    public void cancelReservation(Vehicle vehicle){
        Optional<Reservation> reservation = reservationList.stream()
                .filter(r -> r != null && Objects.equals(r.getVehicle(), vehicle))
                .findFirst();
        if(reservation.isEmpty()){
            System.out.println("No Reservation Found for Vehicle :- " + vehicle.getNumber());
            return;
        }
        System.out.println("Reservation Found for Vehicle :- " + vehicle.getNumber() + " and is cancelled");
        reservationList.remove(reservation.get());
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleInventoryManagement getVehicleInventoryManagement() {
        return vehicleInventoryManagement;
    }

    public void setVehicleInventoryManagement(VehicleInventoryManagement vehicleInventoryManagement) {
        this.vehicleInventoryManagement = vehicleInventoryManagement;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }





    Location location;
    VehicleInventoryManagement vehicleInventoryManagement;
    List<Reservation>reservationList;
}
