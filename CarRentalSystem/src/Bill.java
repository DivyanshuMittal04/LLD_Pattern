import java.time.Duration;

public class Bill {
    Reservation reservation;

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    boolean isPaid;
    double amount;

    public double computeBillAmount(){
        return 100.00 + (reservation.getBookedTo().getHour() - reservation.getBookedFrom().getHour())*50;
    }

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.isPaid = false;
        this.amount = computeBillAmount();
    }
}
