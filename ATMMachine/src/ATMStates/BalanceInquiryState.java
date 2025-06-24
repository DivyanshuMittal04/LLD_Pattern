package ATMStates;

import models.ATMMachine;
import models.Card;

public class BalanceInquiryState extends ATMState{
    public BalanceInquiryState() {
        System.out.println("Machine is in Balance Inquiry State");
    }

    @Override
    public void displayBalance(ATMMachine atmMachine, Card card){
        System.out.println("Balance of your account is " + card.getBalance());
        atmMachine.setAtmState(new IdleState());
    }
}
