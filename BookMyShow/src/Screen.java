import java.util.List;
import java.util.Objects;

public class Screen {
    int id;

    public Screen(int id, List<Seat> seatMap) {
        this.id = id;
        this.seatMap = seatMap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(List<Seat> seatMap) {
        this.seatMap = seatMap;
    }

    public Seat getSeatById(int id){
        return seatMap.stream().filter(seat -> Objects.equals(seat.getId(),id)).findFirst().orElse(null);
    }

    List<Seat> seatMap;
}
