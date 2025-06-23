package States.impl;

import States.State;
import VendingMachine.*;

import java.util.List;

public class SelectionState implements State {
    public SelectionState() {
        System.out.println("Machine is in selection state");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for SELECTION state");
    }

    @Override
    public void insertCoins(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Invalid Operation for SELECTION state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) {
        System.out.println("Invalid Operation for SELECTION state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) {
        Item item = vendingMachine.getInventory().getProduct(code);
        if(item == null){
            vendingMachine.setVendingState(new IdleState(vendingMachine));
            return;
        }

        int totalMoney = 0;
        for(int i=0;i<vendingMachine.getCoinList().size();i++)
            totalMoney += vendingMachine.getCoinList().get(i).getValue();

        if(totalMoney < item.getPrice()){
            System.out.println("Insufficient Money, refunding back");
            getRefund(vendingMachine);
        } else if(totalMoney >= item.getPrice()){
            if(totalMoney > item.getPrice())
            System.out.println("Giving back the change in dispense tray" + (totalMoney - item.getPrice()));
            vendingMachine.setVendingState(new DispenseState());
        }

    }

    @Override
    public List<Coin> getRefund(VendingMachine vendingMachine) {
        System.out.println("Refunding full amount");
        vendingMachine.setVendingState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) {
        vendingMachine.setVendingState(new DispenseState());
        return null;
    }

    @Override
    public int getChange(int returnMoney) {
        return 0;
    }
}
