package VendingMachine;

import States.State;
import States.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    State vendingState;
    Inventory inventory;
    List<Coin> coinList;

    public State getVendingState() {
//        System.out.println("| Vending Current State - " + vendingState + " |");
        return vendingState;
    }

    public void setVendingState(State vendingState) {
        this.vendingState = vendingState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }

    public VendingMachine() {
        this.vendingState = new IdleState();
        this.inventory = new Inventory(10);
        this.coinList = new ArrayList<>();
    }
}
