package WithdrawalProcessor;

import models.ATMMachine;

public class FiveHundredNoteProcessor extends CashWithdrawalProcessor{
    public FiveHundredNoteProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public boolean withdrawCash(ATMMachine atmMachine, int moneyToWithdraw){
        int fiveHundredNotes = moneyToWithdraw / 500;
        int remainingAmount = moneyToWithdraw % 500;

        if(fiveHundredNotes <= atmMachine.getNoOfFiveHundredNotes()){
            atmMachine.reduceFiveHundredNotes(fiveHundredNotes);
        } else {
            remainingAmount += (fiveHundredNotes - atmMachine.getNoOfFiveHundredNotes())*500;
            atmMachine.reduceFiveHundredNotes(fiveHundredNotes - atmMachine.getNoOfFiveHundredNotes());
        }

        if(remainingAmount >= 0)
            return super.withdrawCash(atmMachine, remainingAmount);
        return false;
    }
}
