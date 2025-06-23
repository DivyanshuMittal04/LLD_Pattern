package States.impl;

import States.State;
import VendingMachine.*;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Machine is in idle state");
    }

    public IdleState(VendingMachine vendingMachine) {
        vendingMachine.setCoinList(new ArrayList<>());
        System.out.println("Machine is in idle state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        vendingMachine.setVendingState(new HasMoneyState());
    }

    @Override
    public int getChange(int returnMoney) {
        System.out.println("Invalid Operation for IDLE state");
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) {
        System.out.println("Invalid Operation for IDLE state");
        return null;
    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for IDLE state");
        return List.of();
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) {
        System.out.println("Invalid Operation for IDLE state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for IDLE state");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Invalid Operation for IDLE state");
    }
}
