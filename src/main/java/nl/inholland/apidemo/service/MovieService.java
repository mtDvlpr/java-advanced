package nl.inholland.apidemo.service;

import nl.inholland.apidemo.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

  private List<Movie> movies;

  public MovieService() {
    this.movies = new ArrayList<>(
        List.of(
            new Movie("The Phantom Menace", "George Lucas", "Action, Adventure, Fantasy", 1999, 136, 6.5),
            new Movie("Attack of the Clones", "George Lucas", "Action, Adventure, Fantasy", 2002, 142, 6.5),
            new Movie("Revenge of the Sith", "George Lucas", "Action, Adventure, Fantasy", 2005, 140, 7.5),
            new Movie("A New Hope", "George Lucas", "Action, Adventure, Fantasy", 1977, 121, 8.6f),
            new Movie("The Empire Strikes Back", "George Lucas", "Action, Adventure, Fantasy", 1980, 124, 8.7),
            new Movie("Return of the Jedi", "George Lucas", "Action, Adventure, Fantasy", 1983, 131, 8.3),
            new Movie("The Force Awakens", "J. J. Abrams", "Action, Adventure, Sci-Fi", 2015, 138, 7.9),
            new Movie("Revenge of the Sith", "Rian Johnson", "Action, Adventure, Fantasy", 2017, 151, 7.0),
            new Movie("Revenge of the Sith", "J. J. Abrams", "Action, Adventure, Fantasy", 2019, 141, 6.6)
        )
    );
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public Movie getMovie(int id) {
    for (Movie movie : movies) {
      if (movie.getId() == id) {
        return movie;
      }
    }
    return null;
  }

  public Movie addMovie(Movie movie) {
    movies.add(movie);
    return movie;
  }

  public Movie updateMovie(int id, Movie newMovie) {
    for (Movie movie : movies) {
      if (movie.getId() == id) {
        movie.setTitle(newMovie.getTitle());
        movie.setCategory(newMovie.getCategory());
        movie.setDirector(newMovie.getDirector());
        movie.setReleaseYear(newMovie.getReleaseYear());
        movie.setRuntime(newMovie.getRuntime());
        movie.setScore(newMovie.getScore());
        return movie;
      }
    }
    return null;
  }

  public Movie deleteMovie(int id) {
    for (Movie movie : movies) {
      if (movie.getId() == id) {
        movies.remove(movie);
        return movie;
      }
    }
    return null;
  }
}
