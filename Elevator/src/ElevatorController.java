public class ElevatorController {
    ElevatorCar elevatorCar;

    void submitExternalRequest(int floor, ElevatorDirection direction){
        elevatorCar.move(floor,direction);
    }

    void submitInternalRequest(int floor){
        elevatorCar.move(floor, ElevatorDirection.DOWN);
    }
    //submitNewRequests(floor, direction);
    //control();
}
