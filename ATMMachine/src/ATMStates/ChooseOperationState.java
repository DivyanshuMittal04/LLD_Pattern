package ATMStates;

import models.ATMMachine;
import models.Card;
import models.OperationType;

public class ChooseOperationState extends ATMState {

    public ChooseOperationState() {
        System.out.println("Machine is in Choose Operation State");
    }

    @Override
    public void chooseOperation(ATMMachine atmMachine, OperationType operation) {
        if(operation.equals(OperationType.CASHWITHDRAWAL))
            atmMachine.setAtmState(new CashWithdrawalState());
        else if(operation.equals(OperationType.BALANCEINQUIRY))
            atmMachine.setAtmState(new BalanceInquiryState());
    }
}
