package WithdrawalProcessor;

import models.ATMMachine;

public class OneHundredNoteProcessor extends CashWithdrawalProcessor{
    public OneHundredNoteProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public boolean withdrawCash(ATMMachine atmMachine, int moneyToWithdraw){
        int oneHundredNotes = moneyToWithdraw / 100;
        int remainingAmount = moneyToWithdraw % 100;

        if(oneHundredNotes <= atmMachine.getNoOfOneHundredNotes()){
            atmMachine.reduceOneHundredNotes(oneHundredNotes);
        } else {
            remainingAmount += (oneHundredNotes - atmMachine.getNoOfOneHundredNotes())*100;
            atmMachine.reduceOneHundredNotes(oneHundredNotes - atmMachine.getNoOfOneHundredNotes());
        }

        if(remainingAmount >= 0)
            return super.withdrawCash(atmMachine, remainingAmount);
        return false;
    }
}
