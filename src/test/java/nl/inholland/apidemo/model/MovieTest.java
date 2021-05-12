package nl.inholland.apidemo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

  private Movie movie;

  @BeforeEach
  public void init() {
    movie = new Movie();
  }

  @Test
  public void creatingMovieShouldNotBeNull() {
    assertNotNull(movie);
  }

  @Test
  public void MovieRuntimeShouldNotBeNegative() {
    assertThrows(IllegalArgumentException.class, () -> movie.setRuntime(-1));
  }
}