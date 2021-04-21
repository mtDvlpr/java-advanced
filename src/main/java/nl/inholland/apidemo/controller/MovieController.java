package nl.inholland.apidemo.controller;

import nl.inholland.apidemo.model.Movie;
import nl.inholland.apidemo.model.MovieNotFoundException;
import nl.inholland.apidemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Movie>> getAllMovies() {
    return ResponseEntity.status(200).body(movieService.getMovies());
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
    return ResponseEntity.status(201).body(movieService.addMovie(movie));
  }

  @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> getMovie(@PathVariable long id) {
    Movie movie = movieService.getMovie(id);

    if (movie == null) {
      throw new MovieNotFoundException(id);
    }

    return ResponseEntity.status(200).body(movie);
  }

  @PutMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie newMovie) {
    Movie movie = movieService.updateMovie(id, newMovie);

    if (movie == null) {
      throw new MovieNotFoundException(id);
    }

    return ResponseEntity.status(200).body(movie);
  }

  @DeleteMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> deleteMovie(@PathVariable long id) {
    Movie movie = movieService.deleteMovie(id);

    if (movie == null) {
      throw new MovieNotFoundException(id);
    }

    return ResponseEntity.status(200).body(movie);
  }
}
