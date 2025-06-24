package models;

public class BankAccount {
    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void updateBalance(int balance){
        this.balance = balance;
    }
}
