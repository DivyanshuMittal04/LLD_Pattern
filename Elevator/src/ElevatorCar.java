public class ElevatorCar {
    int id;

    public void setDisplay() {
        this.display = new ElevatorDisplay(currentFloor, direction);
    }

    ElevatorDisplay display;
    int currentFloor;
    ElevatorDirection direction;
    ElevatorStatus status;
    ElevatorInternalButton internalButtons;
    ElevatorDoors doors;

    ElevatorCar(){
        this.status = ElevatorStatus.IDLE;
        this.currentFloor = 0;
        this.direction = ElevatorDirection.UP;
        this.internalButtons = new ElevatorInternalButton();
        setDisplay();
        this.doors = new ElevatorDoors();
    }

    public void showDisplay(){
        display.showDisplay();
    }

    boolean move(int destinationFloor, ElevatorDirection direction){
        int startFloor = currentFloor;
        if(direction == ElevatorDirection.UP) {
            for(int i = startFloor; i<=destinationFloor; i++) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }

        if(direction == ElevatorDirection.DOWN) {
            for(int i = startFloor; i>=destinationFloor; i--) {

                this.currentFloor = startFloor;
                setDisplay();
                showDisplay();
                if(i == destinationFloor) {
                    return true;
                }
            }
        }
        return false;
    }

}
