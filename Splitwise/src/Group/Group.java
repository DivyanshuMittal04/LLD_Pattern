package Group;

import Expense.Expense;
import Expense.ExpenseController;
import Split.Split;
import Expense.SplitType;
import User.User;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    String groupId;
    List<User> userList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    List<Expense> expenses;

    ExpenseController expenseController;

    public Group(String name, String groupId) {
        this.name = name;
        this.groupId = groupId;
        userList = new ArrayList<>();
        expenses = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void removeUser(User user) {
        userList.remove(user);
    }


    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, SplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, splitDetails, splitType, paidByUser);
        expenses.add(expense);
        return expense;
    }



}
