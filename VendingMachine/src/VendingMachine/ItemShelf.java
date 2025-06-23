package VendingMachine;
public class ItemShelf {
    Item item;
    int code;
    boolean isSoldOut;

    public ItemShelf() {
    }

    public Item getItems() {
        return item;
    }

    public void setItems(Item items) {
        this.item = items;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }
}
