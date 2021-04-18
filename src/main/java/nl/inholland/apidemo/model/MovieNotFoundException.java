package nl.inholland.apidemo.model;

public class MovieNotFoundException extends RuntimeException {

  public MovieNotFoundException(int id) {
    super("Could not find the specified movie.;" + id);
  }
}
