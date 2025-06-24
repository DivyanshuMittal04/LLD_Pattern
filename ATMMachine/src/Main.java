import ATMStates.ATMState;
import models.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine(5,5,2);
        User user = createUser();
        ATMState atmState = atmMachine.getAtmState();

        System.out.println("|Money in the ATM|" + atmMachine.getAtmBalance());

        System.out.println("|Inserting Card|");
        atmState.insertCard(atmMachine,user.getCard());
        atmState = atmMachine.getAtmState();

        System.out.println("|Authenticating Card Pin|");
        atmState.authenticatePin(atmMachine,user.getCard(),1234);
        atmState = atmMachine.getAtmState();

        System.out.println("|Choose Operation|");
        atmState.chooseOperation(atmMachine, OperationType.CASHWITHDRAWAL);
        atmState = atmMachine.getAtmState();

        System.out.println("|Withdrawing Cash|");
        atmState.cashWithdrawal(atmMachine,user.getCard(),2700);

        System.out.println("|Remaining Money in the ATM|" + atmMachine.getAtmBalance());



    }

    private static User createUser(){
        return new User("Divyanshu", createCard());
    }

    private static Card createCard(){
        return new Card(1234,createBankAccount());
    }

    private static BankAccount createBankAccount(){
        return new BankAccount(3000);
    }
}