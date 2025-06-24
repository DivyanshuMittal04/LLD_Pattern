package WithdrawalProcessor;

import models.ATMMachine;

public class CashWithdrawalProcessor {
    CashWithdrawalProcessor cashWithdrawalProcessor;

    public CashWithdrawalProcessor(CashWithdrawalProcessor cashWithdrawalProcessor) {
        this.cashWithdrawalProcessor = cashWithdrawalProcessor;
    }

    public boolean withdrawCash(ATMMachine atmMachine, int moneyToWithdraw){
        if(cashWithdrawalProcessor != null){
           return cashWithdrawalProcessor.withdrawCash(atmMachine, moneyToWithdraw);
        }
        return moneyToWithdraw <= 0;
    }
}
