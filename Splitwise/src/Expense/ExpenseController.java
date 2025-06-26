package Expense;

import BalanceSheet.BalanceSheetController;
import Split.ExpenseSplitType;
import Split.Split;
import Split.SplitFactory;

import User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double amount, List<Split> splitList, SplitType splitType, User paidBy) {
        Expense expense = null;
        ExpenseSplitType expenseSplitType = SplitFactory.getExpenseSplitType(splitType);
        if(expenseSplitType.validateSplit(splitList,amount)){
            splitList = expenseSplitType.computeAmount(splitList, amount);
            expense = new Expense(expenseId, description, amount, paidBy, splitType, splitList);
        }

        balanceSheetController.updateBalanceSheet(paidBy,splitList,amount);
        return expense;
    }
}
