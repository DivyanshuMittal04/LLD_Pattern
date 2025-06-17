package model.Vehicle;

import model.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType, String vehicleNumber){
        return switch (vehicleType) {
            case CAR -> new Car(vehicleNumber);
            case MOTORCYCLE -> new Motorcycle(vehicleNumber);
            default -> throw new IllegalArgumentException("Invalid Vehicle Type");
        };
    }
}
