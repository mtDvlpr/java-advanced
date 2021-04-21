package nl.inholland.apidemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Director {

  @Id
  @GeneratedValue
  private long id;
  private String name;

  @JsonManagedReference
  @OneToMany(mappedBy = "director")
  private Set<Movie> movies = new HashSet<>();

  public Director() {

  }

  public Director(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public Set<Movie> getMovies() {
    return movies;
  }

  public void setMovies(Set<Movie> movies) {
    this.movies = movies;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Director{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", movies=").append(movies);
    sb.append('}');
    return sb.toString();
  }
}
