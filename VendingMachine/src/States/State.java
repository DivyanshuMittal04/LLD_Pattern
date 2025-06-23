package States;

import java.util.List;
import VendingMachine.*;

public interface State {
    public void pressInsertCashButton(VendingMachine vendingMachine);
    public void insertCoins(VendingMachine vendingMachine, Coin coin);
    public void pressSelectProductButton(VendingMachine vendingMachine);
    public void chooseProduct(VendingMachine vendingMachine, int code);
    public List<Coin> getRefund(VendingMachine vendingMachine);
    public Item dispenseProduct(VendingMachine vendingMachine, int code);
    public int getChange(int returnMoney);
}
