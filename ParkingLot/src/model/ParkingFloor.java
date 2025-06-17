package model;

import model.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    Map<ParkingSpotType, List<ParkingSpot>> list;
    DisplayBoard displayBoard;
    Map<ParkingSpotType, Integer> board;

    ParkingFloor(){
        list = new HashMap<>();
        this.initSpots();
        board = new HashMap<>();
        for(Map.Entry<ParkingSpotType, List<ParkingSpot>> i: list.entrySet()){
            board.put(i.getKey(),i.getValue().size());
        }
        displayBoard = new DisplayBoard(board);
    }

    void initSpots(){
        list.put(ParkingSpotType.CAR,createParkingSpots(ParkingSpotType.CAR,100));
        list.put(ParkingSpotType.MOTORCYCLE,createParkingSpots(ParkingSpotType.MOTORCYCLE,200));
    }

    List<ParkingSpot> createParkingSpots(ParkingSpotType parkingSpotType, int size){
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for(int i=0; i<size; i++){
            parkingSpotList.add(new ParkingSpot());
        }
        return parkingSpotList;
    }

    public boolean canPark(Vehicle v){
        List<ParkingSpot> parkingSpots = list.get(v.getParkingSpotType());
//        if(!parkingSpots.isEmpty())
//            return false;
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isEmpty) {
                parkingSpot.parkVehicle(v);
                displayBoard.updateBoard(v.getParkingSpotType(), false);
                return true;
            }
        }
        return false;
    }

    public boolean removeVehicle(Vehicle v){
        List<ParkingSpot> parkingSpots = list.get(v.getParkingSpotType());
//        if(parkingSpots.isEmpty())
//            return false;
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isEmpty()) {
                Vehicle parkedVehicle = parkingSpot.getVehicle();
                if (parkedVehicle != null && parkedVehicle.getVehicleNumber().equals(v.getVehicleNumber())) {
                    parkingSpot.removeVehicle();
                    displayBoard.updateBoard(v.getParkingSpotType(), true);
                    return true;
                }
            }
        }
        return false;
    }

    public void display(){
        displayBoard.display();
    }

}
