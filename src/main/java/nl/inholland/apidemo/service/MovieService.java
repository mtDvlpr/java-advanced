package nl.inholland.apidemo.service;

import nl.inholland.apidemo.model.Movie;

import java.util.List;

public interface MovieService {
  List<Movie> getMovies();
  Movie getMovie(long id);
  Movie addMovie(Movie movie);
  Movie updateMovie(long id, Movie newMovie);
  Movie deleteMovie(long id);
}
