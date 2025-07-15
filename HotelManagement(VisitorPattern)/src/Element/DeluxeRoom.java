package Element;

import Visitor.Visitor;

public class DeluxeRoom implements Room{
    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int roomPrice = 0;
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
