package nl.inholland.apidemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stock {

  @Id
  @GeneratedValue
  private long id;
  private int quantity;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name="movie_id", referencedColumnName = "id")
  private Movie movie;

  public Stock() {
  }

  public Stock(int quantity, Movie movie) {
    this.quantity = quantity;
    this.movie = movie;
  }

}
