package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Inventory {
    List<ItemShelf> itemShelves;

    public List<ItemShelf> getItemShelves() {
        return itemShelves;
    }

    public void setItemShelves(List<ItemShelf> itemShelves) {
        this.itemShelves = itemShelves;
    }

    public Inventory(int size) {
        this.itemShelves = new ArrayList<>(size);
        createInitialInventory(size);
    }

    public void createInitialInventory(int size){
        int startCode = 101;
        for(int i=0;i<size;i++){
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setCode(startCode++);
            itemShelf.setSoldOut(true);
            itemShelves.add(itemShelf);
        }
    }

    public void addItem(Item item, int code){
        ItemShelf itemShelf = itemShelves.stream().
                filter(itemShelf1 -> Objects.equals(itemShelf1.getCode(),code)).
                findFirst().
                orElse(null);
        if(itemShelf == null){
            System.out.println("Invalid Code");
            return;
        }
        if(itemShelf.isSoldOut()){
            itemShelf.setSoldOut(true);
            itemShelf.setItems(item);
            System.out.println("Item added to inventory");
        }else {
            System.out.println("Item already present");
        }
    }

    public void updateSoldOut(Item item){
        ItemShelf itemShelf = itemShelves.stream().
                filter(itemShelf1 -> itemShelf1.getItems().equals(item)).
                findFirst().
                orElse(null);
        if(itemShelf == null){
            System.out.println("No Such Item Found");
            return;
        }
        if(itemShelf.isSoldOut()){
            System.out.println("Item already sold out");
        }else {
            itemShelf.setSoldOut(true);
            System.out.println("Item marked as sold out");

        }
    }

    public Item getProduct(int code){
        ItemShelf itemShelf = itemShelves.stream().
                filter(itemShelf1 -> Objects.equals(itemShelf1.getCode(),code)).
                findFirst().
                orElse(null);
        if(itemShelf == null){
            System.out.println("Invalid Code");
            return null;
        }
        if(itemShelf.isSoldOut()){
            System.out.println("Item Sold Out");
            return null;
        }else {
            return itemShelf.getItems();
        }
    }
}
