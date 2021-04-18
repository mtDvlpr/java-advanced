package nl.inholland.apidemo.controller;

import nl.inholland.apidemo.model.Movie;
import nl.inholland.apidemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/movies")
public class MovieController {

  @Autowired
  private MovieService service;

  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Movie>> getAllMovies() {
    return ResponseEntity.status(200).body(service.getMovies());
  }

  @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
    return ResponseEntity.status(201).body(service.addMovie(movie));
  }

  @GetMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> getMovie(@PathVariable int id) {
    Movie movie = service.getMovie(id);
    return ResponseEntity.status(movie != null ? 200 : 404).body(movie);
  }

  @PutMapping(value ="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestBody Movie newMovie) {
    Movie movie = service.updateMovie(id, newMovie);
    return ResponseEntity.status(movie != null ? 200 : 404).body(movie);
  }

  @DeleteMapping(value ="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Movie> deleteMovie(@PathVariable int id) {
    Movie movie = service.deleteMovie(id);
    return ResponseEntity.status(movie != null ? 200 : 404).body(movie);
  }
}
