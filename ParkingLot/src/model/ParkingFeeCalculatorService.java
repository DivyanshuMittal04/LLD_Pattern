package model;

import model.Vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingFeeCalculatorService {

    public double calculateFee(Vehicle v) {

        long durationInMinutes = Duration.between(v.getTicket().getEntryTime(), LocalDateTime.now()).toMinutes();

        return switch (v.getParkingSpotType()) {
            case CAR -> computeCarFee(durationInMinutes);
            case MOTORCYCLE -> computebikeFee(durationInMinutes);
            default -> throw new IllegalArgumentException("Incorrect Spot Type");
        };
    }

    private double computebikeFee(long minutes) {
        return 10 + (minutes / 60) * 5;
    }

    private double computeCarFee(long minutes) {
        return 20 + (minutes / 60) * 10;
    }
}
