package models;

public class ATMRoom {
    User user;
    ATMMachine atmMachine;

    public ATMRoom(User user, ATMMachine atmMachine) {
        this.user = user;
        this.atmMachine = atmMachine;
    }
}
