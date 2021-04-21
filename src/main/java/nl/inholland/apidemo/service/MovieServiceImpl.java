package nl.inholland.apidemo.service;

import nl.inholland.apidemo.model.Movie;
import nl.inholland.apidemo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> getMovies() {
    return (List<Movie>)movieRepository.findAll();
  }

  public Movie getMovie(long id) {
    return movieRepository.findById(id).orElse(null);
  }

  public Movie addMovie(Movie movie) {
    movieRepository.save(movie);
    return movie;
  }

  public Movie updateMovie(long id, Movie newMovie) {
    Movie oldMovie = movieRepository.findById(id).orElse(null);

    if (oldMovie != null) {
      oldMovie.setTitle(newMovie.getTitle());
      oldMovie.setScore(newMovie.getScore());
      oldMovie.setRuntime(newMovie.getRuntime());
      oldMovie.setReleaseYear(newMovie.getReleaseYear());
      oldMovie.setCategory(newMovie.getCategory());
      oldMovie.setDirector(newMovie.getDirector());
      movieRepository.save(oldMovie);
    }
    return oldMovie;
  }

  public Movie deleteMovie(long id) {
    Movie movie = movieRepository.findById(id).orElse(null);

    if (movie != null) {
      movieRepository.delete(movie);
    }
    return movie;
  }
}
