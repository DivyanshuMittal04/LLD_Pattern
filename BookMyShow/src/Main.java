//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.createBooking("ABCD1");
        bookMyShow.createBooking("ABCD2");
        bookMyShow.createBooking("ABCD1");
    }
}