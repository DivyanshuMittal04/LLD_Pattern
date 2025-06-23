package States.impl;

import States.State;
import VendingMachine.*;

import java.util.List;

public class DispenseState implements State {
    public DispenseState() {
        System.out.println("Machine is in dispense state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for DISPENSE state");
    }

    @Override
    public int getChange(int returnMoney) {
        System.out.println("Invalid Operation for DISPENSE state");
        return 0;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) {
        Item item = vendingMachine.getInventory().getProduct(code);
        vendingMachine.getInventory().updateSoldOut(item);
        vendingMachine.setVendingState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for DISPENSE state");
        return List.of();
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) {
        System.out.println("Invalid Operation for DISPENSE state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for DISPENSE state");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Invalid Operation for DISPENSE state");
    }
}
