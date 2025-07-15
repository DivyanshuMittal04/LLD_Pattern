package Visitor;

import Element.DeluxeRoom;
import Element.DoubleRoom;
import Element.SingleRoom;

public class RoomPricingVisitor implements  Visitor {
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Pricing for Single Room: 1000");
        room.setRoomPrice(1000);
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Pricing for Double Room: 2000");
        room.setRoomPrice(2000);
    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Pricing for Deluxe Room: 3000");
        room.setRoomPrice(3000);
    }
}
