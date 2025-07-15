package Element;

import Visitor.Visitor;

public class SingleRoom implements Room{
    public int roomPrice = 0;

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
