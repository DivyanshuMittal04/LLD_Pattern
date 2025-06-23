import States.State;
import VendingMachine.*;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        System.out.println("| Filling up Inventory |");
        fillUpInventory(vendingMachine);
        displayInventory(vendingMachine);
        State vendingState = vendingMachine.getVendingState();

        System.out.println("| Pressing Insert Coins Button |");

        vendingState.pressInsertCashButton(vendingMachine);
        vendingState = vendingMachine.getVendingState();


        System.out.println("| Inserting Coins |");

        vendingState.insertCoins(vendingMachine,Coin.ONERUPEE);
        vendingState.insertCoins(vendingMachine,Coin.TWORUPEE);
        vendingState.insertCoins(vendingMachine,Coin.TENRUPEE);

        System.out.println("| Pressing Product Choose Button |");

        vendingState.pressSelectProductButton(vendingMachine);
        vendingState = vendingMachine.getVendingState();

        System.out.println("| Choosing Product |");

        vendingState.chooseProduct(vendingMachine,106);
        vendingState = vendingMachine.getVendingState();

        Item item = vendingState.dispenseProduct(vendingMachine,106);

        System.out.println("| Product dispensed |" + item.getItemType());

        displayInventory(vendingMachine);







    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        List<ItemShelf> slots = vendingMachine.getInventory().getItemShelves();
        for (int i = 0; i < slots.size(); i++) {
            Item newItem = new Item();
            if(i<3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i<5){
                newItem.setItemType(ItemType.WATER);
                newItem.setPrice(9);
            }else if(i<7){
                newItem.setItemType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i<10){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots.get(i).setItems(newItem);
            slots.get(i).setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        List<ItemShelf> slots = vendingMachine.getInventory().getItemShelves();
        for (int i = 0; i < slots.size(); i++) {

            System.out.println("CodeNumber: " + slots.get(i).getCode() +
                    " Item: " + slots.get(i).getItems().getItemType().name() +
                    " Price: " + slots.get(i).getItems().getPrice() +
                    " isAvailable: " + !slots.get(i).isSoldOut());
        }
    }
}