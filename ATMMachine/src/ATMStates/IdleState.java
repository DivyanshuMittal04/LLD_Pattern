package ATMStates;

import models.ATMMachine;
import models.Card;

public class IdleState extends ATMState{
    public IdleState() {
        System.out.println("Machine is in IDLE state");
    }

    public IdleState(ATMMachine atmMachine) {
        System.out.println("Machine is in IDLE state");
    }

    @Override
    public void insertCard(ATMMachine atmMachine, Card card) {
        atmMachine.setAtmState(new HasCardState());
    }

    @Override
    public void returnCard(ATMMachine atmMachine){
        System.out.println("Invalid Operation on IDLE state");
    }

    @Override
    public void exitAtm(ATMMachine atmMachine){
        System.out.println("Invalid Operation on IDLE state");
    }
}
