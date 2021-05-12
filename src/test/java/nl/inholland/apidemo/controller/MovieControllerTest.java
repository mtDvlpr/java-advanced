package nl.inholland.apidemo.controller;

import nl.inholland.apidemo.model.Director;
import nl.inholland.apidemo.model.Movie;
import nl.inholland.apidemo.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

  @Autowired private MockMvc mvc;

  @MockBean private MovieService movieService;

  private Movie movie;

  @BeforeEach
  public void init() {
    movie = new Movie("Title", new Director("Dir"), "cat", 2010, 120, 8.4);
  }

  @Test
  public void getAllMoviesShouldReturnJsonArray() throws Exception {
    given(movieService.getMovies()).willReturn(List.of(movie));
    this.mvc
        .perform(get("/movies"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].title").value(movie.getTitle()));
  }

  @Test
  public void creatingMovieShouldReturnStatusCreate201() throws Exception {
    this.mvc
        .perform(post("/movies").contentType(MediaType.APPLICATION_JSON).content("{}"))
        .andExpect(status().isCreated());
  }
}
