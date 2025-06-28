package User;

import BalanceSheet.BalanceSheet;

public class User {
    String name;
    String id;
    BalanceSheet balanceSheet;

    public User(String id, String name) {
        this.name = name;
        this.id = id;
        balanceSheet = new BalanceSheet();
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
