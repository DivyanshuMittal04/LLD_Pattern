package models;

public class Card {
    int cvv;
    int pin;
    BankAccount account;

    public Card(int pin, BankAccount account) {
        this.pin = pin;
        this.account = account;
    }

    public boolean isPinCorrect(int pin) {
        return pin == this.pin;
    }

    public int getBalance(){
        return account.getBalance();
    }

    public void setBalance(int balance){
        account.setBalance(balance);
    }
}
