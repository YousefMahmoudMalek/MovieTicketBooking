package model;

public class ShowBuilder {
    private Movie movie;
    private Theater theater;
    private String time;
    private int rows = 5;
    private int cols = 4;
    private double price = 8.0;

    public ShowBuilder setMovie(Movie m) { this.movie = m; return this; }
    public ShowBuilder setTheater(Theater t) { this.theater = t; return this; }
    public ShowBuilder setTime(String time) { this.time = time; return this; }
    public ShowBuilder setSeatLayout(int rows, int cols) { this.rows = rows; this.cols = cols; return this; }
    public ShowBuilder setPrice(double p) { this.price = p; return this; }

    public Show build() {
        if (movie == null) throw new IllegalStateException("movie null");
        if (theater == null) theater = new Theater("Main Hall");
        return new Show(movie, theater, time == null ? "20:00" : time, rows, cols, price);
    }
}
