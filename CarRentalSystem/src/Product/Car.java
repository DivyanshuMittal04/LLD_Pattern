package Product;

public class Car extends Vehicle{
    public Car(int id, String number, Status status, int mileage, int cc, int kmDriven, int age, int numberOfSeats, int hourlyCost, int dayCost) {
        super(id, number, VehicleType.CAR, status, mileage, cc, kmDriven, age, numberOfSeats, hourlyCost, dayCost);
    }
}
