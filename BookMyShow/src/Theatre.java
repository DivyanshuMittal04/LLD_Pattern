import java.util.List;

public class Theatre {
    int id;
    Location location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Screen> getListOfScreens() {
        return listOfScreens;
    }

    public void setListOfScreens(List<Screen> listOfScreens) {
        this.listOfScreens = listOfScreens;
    }

    public List<Shows> getListOfShows() {
        return listOfShows;
    }

    public void setListOfShows(List<Shows> listOfShows) {
        this.listOfShows = listOfShows;
    }

    public Theatre(int id, Location location, List<Screen> listOfScreens, List<Shows> listOfShows) {
        this.id = id;
        this.location = location;
        this.listOfScreens = listOfScreens;
        this.listOfShows = listOfShows;
    }

    List<Screen>listOfScreens;
    List<Shows>listOfShows;
}
