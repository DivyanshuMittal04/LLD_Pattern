package Visitor;

import Element.DeluxeRoom;
import Element.DoubleRoom;
import Element.SingleRoom;

public class RoomMaintainanceVisitor implements Visitor{
    @Override
    public void visit(SingleRoom room) {
        System.out.println("Maintenance for Single Room");
    }

    @Override
    public void visit(DoubleRoom room) {
        System.out.println("Maintenance for Double Room");

    }

    @Override
    public void visit(DeluxeRoom room) {
        System.out.println("Maintenance for Deluxe Room");

    }
}
