package States.impl;

import States.State;
import VendingMachine.*;

import java.util.ArrayList;
import java.util.List;

public class HasMoneyState implements State {
    public HasMoneyState() {
        System.out.println("Machine is in hasMoney state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for HASMONEY state");
    }

    @Override
    public int getChange(int returnMoney) {
        System.out.println("Invalid Operation for HASMONEY state");
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) {
        System.out.println("Invalid Operation for HASMONEY state");
        return null;
    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) {
        System.out.println("Money Refunded");
        vendingMachine.setVendingState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) {
        System.out.println("Invalid Operation for HASMONEY state");

    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        vendingMachine.setVendingState(new SelectionState());
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {
        List<Coin> list = vendingMachine.getCoinList();
        list.add(coin);
        vendingMachine.setCoinList(list);
    }
}
