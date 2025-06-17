import Product.Vehicle;

import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {
    User user;
    ReservationStatus reservationStatus;

    public Reservation(User user, Vehicle vehicle, LocalDateTime bookedFrom, LocalDateTime bookedTo) {
        this.user = user;
        this.vehicle = vehicle;
        this.reservationId += 1;
        this.bookingDate = new Date();
        this.bookedFrom = bookedFrom;
        this.bookedTo = bookedTo;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getBookedFrom() {
        return bookedFrom;
    }

    public void setBookedFrom(LocalDateTime bookedFrom) {
        this.bookedFrom = bookedFrom;
    }

    public LocalDateTime getBookedTo() {
        return bookedTo;
    }

    public void setBookedTo(LocalDateTime bookedTo) {
        this.bookedTo = bookedTo;
    }

    Vehicle vehicle;
    int reservationId = 1;
    Date bookingDate;
    LocalDateTime bookedFrom;
    LocalDateTime bookedTo;
}
