package nl.inholland.apidemo.model;

public class Movie {

  private static int nextId = 1;

  private final int id;
  private String title;
  private String director;
  private String category;
  private int releaseYear;
  private int runtime;
  private double score;

  public Movie(String title, String director, String category, int releaseYear, int runtime, double score) {
    this.id = nextId;
    this.title = title;
    this.director = director;
    this.category = category;
    this.releaseYear = releaseYear;
    this.runtime = runtime;
    this.score = score;

    nextId++;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
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
    return "Movie{" +
        "uuid=" + id +
        ", title='" + title + '\'' +
        ", directors=" + director +
        ", category='" + category + '\'' +
        ", releaseYear=" + releaseYear +
        ", runtime=" + runtime +
        ", score=" + score +
        '}';
  }
}
