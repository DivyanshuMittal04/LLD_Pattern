import java.util.List;

public class InternalButtonDIspatcher {
    List<ElevatorController> elevatorControllerList;

    //submitRequest(liftId);

    void submitInternalRequest(int elevatorID, int floor){
        for(ElevatorController elevatorController: elevatorControllerList){
            if(elevatorID == elevatorController.elevatorCar.id){
                elevatorController.submitInternalRequest(floor);
            }
        }
    }
}
