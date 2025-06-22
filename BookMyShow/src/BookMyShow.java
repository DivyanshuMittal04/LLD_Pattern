import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    TheatreController theatreController;
    MovieController movieController;
    Location location = new Location("Bengaluru");

    BookMyShow(){
        theatreController = new TheatreController();
        movieController = new MovieController();
        initialise();
    }

    public void initialise(){
        addMovies();
        createTheatres();
    }

    private void addMovies() {
        Movie movie1 = new Movie(1,"ABCD1", Duration.ofHours(1));
        Movie movie2 = new Movie(2,"ABCD2", Duration.ofHours(1));
        movieController.addMovie(location,movie1);
        movieController.addMovie(location,movie2);
    }


    public void createTheatres(){
        Movie movie1 = movieController.getMovieByName("ABCD1");
        Movie movie2 = movieController.getMovieByName("ABCD2");
        Shows firstShow = createShows(1,movie1,createScreen().getFirst(),LocalDateTime.now());
        Shows secondShow = createShows(2,movie2,createScreen().getFirst(),LocalDateTime.now().plusHours(2));
        List<Shows> showsList = new ArrayList<>();
        showsList.add(firstShow);
        showsList.add(secondShow);
        Theatre theatre1 = new Theatre(2,location,createScreen(),showsList);
        firstShow = createShows(1,movie2,createScreen().getFirst(),LocalDateTime.now());
        secondShow = createShows(2,movie1,createScreen().getFirst(),LocalDateTime.now().plusHours(2));
        List<Shows> showsList2 = new ArrayList<>();
        showsList2.add(firstShow);
        showsList2.add(secondShow);
        Theatre theatre2 = new Theatre(2,location,createScreen(),showsList2);
        theatreController.addTheatre(location,theatre1);
        theatreController.addTheatre(location,theatre2);
    }

    public List<Screen> createScreen(){
        Seat seat1 = new Seat(1,1,SeatCategory.SILVER);
        Seat seat2 = new Seat(2,2,SeatCategory.GOLD);
        Seat seat3 = new Seat(3,3,SeatCategory.PLATINUM);
        createSeats result = new createSeats(seat1, seat2, seat3);
        List<Seat> seatList = new ArrayList<>(List.of(new Seat[]{result.seat1(), result.seat2(), result.seat3()}));
        return Collections.singletonList(new Screen(1, seatList));
    }

    public Shows createShows(int showId, Movie movie, Screen screen, LocalDateTime startTime){
        return new Shows(showId,movie,screen, startTime);
    }

    private record createSeats(Seat seat1, Seat seat2, Seat seat3) {
    }

    public void createBooking(String movieName){
        Movie movie = movieController.getMovieByName(movieName);
        if(movie == null){
            System.out.println("Invalid Movie");
            return;
        }
        List<Shows> shows = new ArrayList<>();
        Map<Theatre, List<Shows>> listOfShowsInCity = theatreController.getAllShows(location,movie);
        for (Map.Entry<Theatre, List<Shows>> entry : listOfShowsInCity.entrySet()) {
            Theatre theatre = entry.getKey();
            shows = entry.getValue();
            break;
        }

        int bookingSeatNumber = 3;
        Shows intersted = shows.getFirst();
        List<Integer>bookedSeats = shows.getFirst().getBookedSeatIds();
        if(!bookedSeats.contains(bookingSeatNumber)){
            Seat seat = intersted.getScreen().getSeatById(bookingSeatNumber);
            List<Seat> bookingSeats = new ArrayList<>();
            bookingSeats.add(seat);
            Booking booking = new Booking(intersted,bookingSeats,new Payment());
            intersted.addBookingSeats(bookingSeats);

        } else {
            System.out.println("Seat is already booked");
            return;
        }

        System.out.println("Booking Success");

    }


}
