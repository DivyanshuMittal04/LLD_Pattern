package Product;

public class Vehicle {
    int id;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getHourlyCost() {
        return hourlyCost;
    }

    public void setHourlyCost(int hourlyCost) {
        this.hourlyCost = hourlyCost;
    }

    public int getDayCost() {
        return dayCost;
    }

    public void setDayCost(int dayCost) {
        this.dayCost = dayCost;
    }

    String number;
    VehicleType type;

    public Vehicle(int id, String number, VehicleType type, Status status, int mileage, int cc, int kmDriven, int age, int numberOfSeats, int hourlyCost, int dayCost) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.status = status;
        this.mileage = mileage;
        this.cc = cc;
        this.kmDriven = kmDriven;
        this.age = age;
        this.numberOfSeats = numberOfSeats;
        this.hourlyCost = hourlyCost;
        this.dayCost = dayCost;
    }

    Status status;
    int mileage;
    int cc;
    int kmDriven;
    int age;
    int numberOfSeats;
    int hourlyCost;
    int dayCost;
}
