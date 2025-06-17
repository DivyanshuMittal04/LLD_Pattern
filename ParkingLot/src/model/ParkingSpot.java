package model;

import model.Vehicle.Vehicle;

public class ParkingSpot {
    int price;
    boolean isEmpty = true;
    Vehicle vehicle;

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isEmpty = false;
    }
    public void removeVehicle(){
        this.vehicle = null;
        this.isEmpty = true;
    };

}
