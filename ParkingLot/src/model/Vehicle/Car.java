package model.Vehicle;

import model.ParkingSpotType;
import model.VehicleType;

public class Car extends Vehicle{

    Car(String number){
        super(number, VehicleType.CAR);
    }

    @Override
    public ParkingSpotType getParkingSpotType() {
        return ParkingSpotType.CAR;
    }
}
