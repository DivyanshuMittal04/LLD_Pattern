package model;

import java.time.LocalDateTime;

public class Ticket {
    LocalDateTime entryTime;


    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpotType getPs() {
        return ps;
    }

    public void setPs(ParkingSpotType ps) {
        this.ps = ps;
    }

    ParkingSpotType ps;

    public Ticket(LocalDateTime entryTime, ParkingSpotType ps){
        this.entryTime = entryTime;
        this.ps = ps;
    }
}
