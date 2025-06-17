package Product;

public class Motorcycle extends Vehicle{
    public Motorcycle(int id, String number, Status status, int mileage, int cc, int kmDriven, int age, int numberOfSeats, int hourlyCost, int dayCost) {
        super(id, number, VehicleType.MOTORCYCLE, status, mileage, cc, kmDriven, age, numberOfSeats, hourlyCost, dayCost);
    }
}
