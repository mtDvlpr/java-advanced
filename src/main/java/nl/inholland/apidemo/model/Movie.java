package nl.inholland.apidemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {

  @Id
  @GeneratedValue
  private long id;
  private String title;

  @ManyToOne
  @JsonBackReference
  private Director director;
  private String category;
  private int releaseYear;
  private int runtime;
  private double score;

  @OneToOne(mappedBy = "movie")
  private Stock stock;

  public Movie() {

  }

  public Movie(String title, Director director, String category, int releaseYear, int runtime, double score) {
    this.title = title;
    this.director = director;
    this.category = category;
    this.releaseYear = releaseYear;
    this.runtime = runtime;
    this.score = score;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public int getRuntime() {
    return runtime;
  }

  public void setRuntime(int runtime) {
    this.runtime = runtime;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Movie{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", director='").append(director).append('\'');
    sb.append(", category='").append(category).append('\'');
    sb.append(", releaseYear=").append(releaseYear);
    sb.append(", runtime=").append(runtime);
    sb.append(", score=").append(score);
    sb.append('}');
    return sb.toString();
  }
}
