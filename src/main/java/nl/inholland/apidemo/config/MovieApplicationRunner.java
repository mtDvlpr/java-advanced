package nl.inholland.apidemo.config;

import nl.inholland.apidemo.model.Director;
import nl.inholland.apidemo.model.Movie;
import nl.inholland.apidemo.model.Stock;
import nl.inholland.apidemo.service.DirectorService;
import nl.inholland.apidemo.service.MovieService;
import nl.inholland.apidemo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class MovieApplicationRunner implements ApplicationRunner {

  @Autowired
  private MovieService movieService;

  @Autowired
  private StockService stockService;

  @Autowired
  private DirectorService directorService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    // Hardcoded entities
    Director lucas = new Director("George Lucas");
    Director abrams = new Director("J. J. Abrams");
    Director johnson = new Director("Rian Johnson");

    List<Movie> movieList = new ArrayList<>(
        List.of(
            new Movie("The Phantom Menace", lucas, "Action, Adventure, Fantasy", 1999, 136, 6.5),
            new Movie("Attack of the Clones", lucas, "Action, Adventure, Fantasy", 2002, 142, 6.5),
            new Movie("Revenge of the Sith", lucas, "Action, Adventure, Fantasy", 2005, 140, 7.5),
            new Movie("A New Hope", lucas, "Action, Adventure, Fantasy", 1977, 121, 8.6),
            new Movie("The Empire Strikes Back", lucas, "Action, Adventure, Fantasy", 1980, 124, 8.7),
            new Movie("Return of the Jedi", lucas, "Action, Adventure, Fantasy", 1983, 131, 8.3),
            new Movie("The Force Awakens", abrams, "Action, Adventure, Sci-Fi", 2015, 138, 7.9),
            new Movie("The Last Jedi", johnson, "Action, Adventure, Fantasy", 2017, 151, 7.0),
            new Movie("The Rise of Skywalker", abrams, "Action, Adventure, Fantasy", 2019, 141, 6.6)
        )
    );

    Stock stock1 = new Stock(10, movieList.get(0));
    Stock stock2 = new Stock(12, movieList.get(1));
    Stock stock3 = new Stock(33, movieList.get(2));

    // Add entities to database
    directorService.addDirector(lucas);
    directorService.addDirector(abrams);
    directorService.addDirector(johnson);

    for (Movie movie : movieList) {
        movieService.addMovie(movie);
    }

    stockService.addStock(stock1);
    stockService.addStock(stock2);
    stockService.addStock(stock3);

    directorService.getAllDirectors().forEach(System.out::println);
  }
}
