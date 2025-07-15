import Element.DeluxeRoom;
import Element.DoubleRoom;
import Element.Room;
import Element.SingleRoom;
import Visitor.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room deluxeRoom = new DeluxeRoom();

        Visitor visitor = new RoomPricingVisitor();
        singleRoom.accept(visitor);
        System.out.println("Single Room Price: " + ((SingleRoom)(singleRoom)).getRoomPrice());
        doubleRoom.accept(visitor);
        System.out.println("Double Room Price: " + ((DoubleRoom)(doubleRoom)).getRoomPrice());
        deluxeRoom.accept(visitor);
        System.out.println("Deluxe Room Price: " + ((DeluxeRoom)(deluxeRoom)).getRoomPrice());

        visitor = new RoomMaintainanceVisitor();
        singleRoom.accept(visitor);
        doubleRoom.accept(visitor);
        deluxeRoom.accept(visitor);
    }
}