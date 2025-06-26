package Expense;

import Split.Split;
import User.User;

import java.util.List;

public class Expense {
    String id;
    String description;

    public Expense(String id, String description, double amount, User paidBy, SplitType splitType, List<Split> splitList) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splitList = splitList;
    }

    double amount;
    User paidBy;
    SplitType splitType;
    List<Split>splitList;
}
