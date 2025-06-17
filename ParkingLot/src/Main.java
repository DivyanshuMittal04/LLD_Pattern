import model.ParkingLot;
import model.Vehicle.Vehicle;
import model.Vehicle.VehicleFactory;
import model.VehicleType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance(1);

        //parkingLot.display();


        Vehicle v1 = VehicleFactory.createVehicle(VehicleType.CAR,"1234");
        parkingLot.parkVehicle(v1);

        parkingLot.display();

        Vehicle v2 = VehicleFactory.createVehicle(VehicleType.CAR,"45343");
        parkingLot.parkVehicle(v2);

        parkingLot.display();

        Vehicle v3 = VehicleFactory.createVehicle(VehicleType.CAR,"46344");
        parkingLot.parkVehicle(v3);

        parkingLot.display();

        Vehicle v4 = VehicleFactory.createVehicle(VehicleType.MOTORCYCLE,"7655");
        parkingLot.parkVehicle(v4);

        parkingLot.display();

        parkingLot.removeVehicle(v1);
        parkingLot.removeVehicle(v4);
        parkingLot.display();
    }
}