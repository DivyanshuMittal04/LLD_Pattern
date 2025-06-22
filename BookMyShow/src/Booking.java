import java.util.List;

public class Booking {
    Shows shows;

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public Booking(Shows shows, List<Seat> bookedSeats, Payment payment) {
        this.shows = shows;
        this.bookedSeats = bookedSeats;
        this.payment = payment;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }

    List<Seat>bookedSeats;
    Payment payment;
}
