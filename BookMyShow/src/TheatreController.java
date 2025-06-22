import java.util.*;

public class TheatreController {
    Map<Location, List<Theatre>> listOfTheatres = new HashMap<>();
    List<Theatre>allTheatres = new ArrayList<>();

    public void addTheatre(Location location, Theatre theatre){
        List<Theatre> movieList = listOfTheatres.get(location);
        if(movieList == null)
            movieList = new ArrayList<>();
        movieList.add(theatre);
        listOfTheatres.put(location,movieList);
        allTheatres.add(theatre);
    }

    public void removeTheatre(Location location, Theatre theatre){
        List<Theatre> movieList = listOfTheatres.get(location);
        movieList.remove(theatre);
        listOfTheatres.put(location,movieList);
        allTheatres.remove(theatre);
    }

    public  Map<Theatre, List<Shows>> getAllShows(Location location, Movie movie){
        Map<Theatre, List<Shows>>theatreVsShows = new HashMap<>();
        List<Theatre> theatres  = listOfTheatres.get(location);
        for(Theatre theatre : theatres) {

            List<Shows> givenMovieShows = new ArrayList<>();
            List<Shows> shows = theatre.getListOfShows();

            for(Shows show : shows) {
                if(Objects.equals(show.getMovie().getName(), movie.getName())) {
                    givenMovieShows.add(show);
                }
            }
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }
        return theatreVsShows;

    }

}
