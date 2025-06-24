package WithdrawalProcessor;

import models.ATMMachine;

public class TwoThousandNoteProcessor extends CashWithdrawalProcessor{
    public TwoThousandNoteProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public boolean withdrawCash(ATMMachine atmMachine, int moneyToWithdraw){
        int twoThousandsNotes = moneyToWithdraw / 2000;
        int remainingAmount = moneyToWithdraw % 2000;

        if(twoThousandsNotes <= atmMachine.getNoOfTwoThousandNotes()){
            atmMachine.reduceTwoThousandNotes(twoThousandsNotes);
        } else {
            remainingAmount += (twoThousandsNotes - atmMachine.getNoOfTwoThousandNotes())*2000;
            atmMachine.reduceTwoThousandNotes(twoThousandsNotes - atmMachine.getNoOfTwoThousandNotes());
        }

        if(remainingAmount >= 0)
            return super.withdrawCash(atmMachine, remainingAmount);
        return false;
    }
}
