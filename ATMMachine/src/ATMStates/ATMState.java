package ATMStates;

import models.ATMMachine;
import models.Card;
import models.OperationType;

public abstract class ATMState {
    public void insertCard(ATMMachine atmMachine, Card card){
        System.out.println("Invalid Operation on " + atmMachine.getAtmState() + "State");
    }


    public boolean authenticatePin(ATMMachine atmMachine, Card card, int pin){
        System.out.println("Invalid Operation on " + atmMachine.getAtmState() + "State");
        return false;
    }

    public void chooseOperation(ATMMachine atmMachine, OperationType operation){
        System.out.println("Invalid Operation on " + atmMachine.getAtmState() + "State");
    }

    public void cashWithdrawal(ATMMachine atmMachine, Card card, int moneyToWithdraw){
        System.out.println("Invalid Operation on " + atmMachine.getAtmState() + "State");
    }

    public void displayBalance(ATMMachine atmMachine, Card card){
        System.out.println("Invalid Operation on " + atmMachine.getAtmState() + "State");
    }


    public void returnCard(ATMMachine atmMachine){
        System.out.println("Please take your card back");
    }

    public void exitAtm(ATMMachine atmMachine){
        returnCard(atmMachine);
        atmMachine.setAtmState(new IdleState());
        System.out.println("Exiting...");
    }


}
