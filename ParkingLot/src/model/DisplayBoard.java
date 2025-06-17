package model;

import java.util.Map;

public class DisplayBoard {
    Map<ParkingSpotType, Integer> spotsRemaining;

    DisplayBoard(Map<ParkingSpotType, Integer> mp){
        this.spotsRemaining = mp;
    }

    void updateBoard(ParkingSpotType parkingSpotType, boolean isReserved){
        int currentSlots = spotsRemaining.get(parkingSpotType);
        if(isReserved){
            spotsRemaining.put(parkingSpotType, currentSlots + 1);
        } else {
            spotsRemaining.put(parkingSpotType, currentSlots - 1);
        }
    }

    void display(){
        for(Map.Entry<ParkingSpotType, Integer> i: spotsRemaining.entrySet()){
            System.out.println("Available Slots for " + i.getKey() + " :- " + i.getValue());
        }
    }

}
