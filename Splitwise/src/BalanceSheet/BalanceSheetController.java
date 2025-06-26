package BalanceSheet;

import Split.Split;
import User.User;

import java.util.List;

public class BalanceSheetController {

    public void updateBalanceSheet(User paidby, List<Split> splitList, double amount){
        BalanceSheet paidByBalanceSheet = paidby.getBalanceSheet();
        for (Split split : splitList) {
            User paidFor = split.getUser();
            BalanceSheet paidForBalanceSheet = paidFor.getBalanceSheet();
            double splitAmount = split.getAmount();
            paidByBalanceSheet.updateBalance(paidFor, splitAmount);
            paidForBalanceSheet.updateBalance(paidby, -splitAmount);
        }
    }

    public void printBalanceSheet(User user) {
        BalanceSheet balanceSheet = user.getBalanceSheet();
        System.out.println("Balance Sheet for " + user.getName() + ":");
        for (User otherUser : balanceSheet.getAllUsers()) {
            double balance = balanceSheet.getBalanceForUser(otherUser);
            if (balance != 0) {
                System.out.println(otherUser.getName() + ": " + balance);
            }
        }
    }
}
