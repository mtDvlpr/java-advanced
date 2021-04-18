package nl.inholland.apidemo.model;

public class Movie {

  private static int nextId = 1;

  private final int id;
  private String title;
  private String directors;
  private String category;
  private int releaseYear;
  private int runtime;
  private double score;

  public Movie(String title, String directors, String category, int releaseYear, int runtime, double score) {
    this.id = nextId;
    this.title = title;
    this.directors = directors;
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

  public String getDirectors() {
    return directors;
  }

  public void setDirectors(String directors) {
    this.directors = directors;
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
        ", directors=" + directors +
        ", category='" + category + '\'' +
        ", releaseYear=" + releaseYear +
        ", runtime=" + runtime +
        ", score=" + score +
        '}';
  }
}
