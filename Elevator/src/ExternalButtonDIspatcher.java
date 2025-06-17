import java.util.List;

public class ExternalButtonDIspatcher {
    List<ElevatorController> elevatorControllerList;

    void submitRequest(int floor, ElevatorDirection direction){
        for(ElevatorController elevatorController: elevatorControllerList){
            elevatorController.submitExternalRequest(floor,direction);
        }
    }
    //submitRequest(int floor, Direction dir)
}
