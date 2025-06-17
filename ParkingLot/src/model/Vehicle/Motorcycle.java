package model.Vehicle;

import model.ParkingSpotType;
import model.VehicleType;

public class Motorcycle extends Vehicle{

    Motorcycle(String number){
        super(number, VehicleType.MOTORCYCLE);
    }

    @Override
    public ParkingSpotType getParkingSpotType() {
        return ParkingSpotType.MOTORCYCLE;
    }
}
