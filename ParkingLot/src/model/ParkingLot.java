package model;

import model.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingFloor> floors;
    int floor;
    private static ParkingLot instance;
    ParkingFeeCalculatorService parkingFeeCalculatorService;

    ParkingLot(int floor){
        floors = new ArrayList<>();
        this.floor = floor;
        for(int i=0;i<floor;i++)
            floors.add(new ParkingFloor());
        parkingFeeCalculatorService = new ParkingFeeCalculatorService();
    }

    public static ParkingLot getInstance(int floor){
        if(instance == null)
            instance = new ParkingLot(floor);
        return instance;
    }

    public void parkVehicle(Vehicle v){
        for(int i=0;i<floor;i++){
            if(floors.get(i).canPark(v)){
                System.out.println("Vehicle Parked Successfully on floor :- " + i);
                return;
            }
        }
        System.out.println("Vehicle Cannot be parked");
    }

    public void removeVehicle(Vehicle v){
        for(int i=0;i<floor;i++){
            if(floors.get(i).removeVehicle(v)){
                double cost = parkingFeeCalculatorService.calculateFee(v);
                System.out.println("Vehicle Removed Successfully from floor :- " + i);
                System.out.println("Parking Charges :- " + cost);
                return;
            }
        }
        System.out.println("Vehicle Cannot be found");
    }

    public void display(){
        for(int i=0; i<floor; i++){
            System.out.print("Floor " + i + " :- ");
            floors.get(i).display();
        }
    }

}
