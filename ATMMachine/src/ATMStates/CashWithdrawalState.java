package ATMStates;

import WithdrawalProcessor.CashWithdrawalProcessor;
import WithdrawalProcessor.FiveHundredNoteProcessor;
import WithdrawalProcessor.OneHundredNoteProcessor;
import WithdrawalProcessor.TwoThousandNoteProcessor;
import models.ATMMachine;
import models.Card;

public class CashWithdrawalState extends ATMState {
    public CashWithdrawalState() {
        System.out.println("Machine is in Cash Withdrawal State");
    }


    @Override
    public void cashWithdrawal(ATMMachine atmMachine, Card card, int moneyToWithdraw) {
        if(card.getBalance() < moneyToWithdraw){
            System.out.println("Insufficient Funds in your account " + card.getBalance());
            exitAtm(atmMachine);
        } else if(atmMachine.getAtmBalance() < moneyToWithdraw){
            System.out.println("Insufficient Funds in the ATM. Please try again later.");
            exitAtm(atmMachine);
        } else {
            CashWithdrawalProcessor cashWithdrawalProcessor = new TwoThousandNoteProcessor(new FiveHundredNoteProcessor(new OneHundredNoteProcessor(null)));
            int noOfTwoThousandNotes = atmMachine.getNoOfTwoThousandNotes();
            int noOfFiveHundredNotes = atmMachine.getNoOfFiveHundredNotes();
            int noOfOneHundredNotes = atmMachine.getNoOfOneHundredNotes();
            if(cashWithdrawalProcessor.withdrawCash(atmMachine,moneyToWithdraw)){
                System.out.println("Money withdrawn successfully, Current Balance in Account:- " + (card.getBalance() - moneyToWithdraw));
                card.setBalance(card.getBalance() - moneyToWithdraw);
            } else {
                System.out.println("No Proper Denomination");
                atmMachine.setNoOfOneHundredNotes(noOfOneHundredNotes);
                atmMachine.setNoOfFiveHundredNotes(noOfFiveHundredNotes);
                atmMachine.setNoOfTwoThousandNotes(noOfTwoThousandNotes);
            }
            atmMachine.updateBalance();
        }

        atmMachine.setAtmState(new IdleState());
    }
}
