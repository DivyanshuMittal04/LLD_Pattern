package model.Vehicle;

import model.ParkingSpotType;
import model.Ticket;
import model.VehicleType;

import java.time.LocalDateTime;

public abstract class Vehicle {
    String vehicleNumber;
    VehicleType vehicleType;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    Ticket ticket;

    Vehicle(String vehicleNumber, VehicleType vehicleType){
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        ticket = new Ticket(LocalDateTime.now(), getParkingSpotType());
    }

    public abstract ParkingSpotType getParkingSpotType();

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

}
