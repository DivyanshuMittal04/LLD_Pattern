public class ElevatorInternalButton {
    InternalButtonDIspatcher internalDispatcher;

    void pressButton(int button, int id){
        internalDispatcher.submitInternalRequest(id,button);
    }
    //pressButton(int button)
}
