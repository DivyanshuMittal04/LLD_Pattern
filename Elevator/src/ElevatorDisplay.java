public class ElevatorDisplay {
    int floor;
    ElevatorDirection elevatorDirection;

    ElevatorDisplay(int floor, ElevatorDirection elevatorDirection){
        this.floor = floor;
        this.elevatorDirection = elevatorDirection;
    }

    public void showDisplay(){
        System.out.println(floor);
        System.out.println(elevatorDirection);
    }

}
