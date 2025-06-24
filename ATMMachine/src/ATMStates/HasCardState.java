package ATMStates;

import models.ATMMachine;
import models.Card;
import models.OperationType;

public class HasCardState extends ATMState {
    public HasCardState() {
        System.out.println("ATM is in Has Card State");
    }

    @Override
    public boolean authenticatePin(ATMMachine atmMachine, Card card, int pin) {
        boolean isPinCorrect = card.isPinCorrect(pin);
        System.out.println("Pin Matching " + isPinCorrect);
        if(isPinCorrect)
            atmMachine.setAtmState(new ChooseOperationState());
        else
            atmMachine.setAtmState(new IdleState());
        return isPinCorrect;
    }
}
