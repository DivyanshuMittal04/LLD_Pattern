import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class MovieController {
    Map<Location, List<Movie>> listOfMovies = new HashMap<>();
    List<Movie>allMovies = new ArrayList<>();

    public Movie getMovieByName(String movieName){
        return allMovies.stream()
                .filter(m -> Objects.equals(m.getName(), movieName))
                .findFirst()
                .orElse(null);

    }

    public void addMovie(Location location, Movie movie){
        List<Movie> movieList = listOfMovies.get(location);
        if(movieList == null)
            movieList = new ArrayList<>();
        movieList.add(movie);
        listOfMovies.put(location,movieList);
        allMovies.add(movie);
    }

    public void removeMovie(Location location, Movie movie){
        List<Movie> movieList = listOfMovies.get(location);
        movieList.remove(movie);
        listOfMovies.put(location,movieList);
        allMovies.remove(movie);
    }
}
