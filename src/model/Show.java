package model;

public class Show {
    private final Movie movie;
    private final Theater theater;
    private final String time;
    private final boolean[][] seats; // true = reserved/blocked
    private final double price;

    public Show(Movie movie, Theater theater, String time, int rows, int cols, double price) {
        this.movie = movie; this.theater = theater; this.time = time;
        this.seats = new boolean[rows][cols];
        this.price = price;
    }

    public Movie getMovie() { return movie; }
    public Theater getTheater() { return theater; }
    public String getTime() { return time; }
    public int getRows() { return seats.length; }
    public int getCols() { return seats[0].length; }
    public double getPrice() { return price; }

    public synchronized boolean isReserved(int r, int c) { return seats[r][c]; }
    public synchronized boolean reserveSeat(int r, int c) {
        if (seats[r][c]) return false;
        seats[r][c] = true; // temp reserve
        return true;
    }
    public synchronized void releaseSeat(int r, int c) { seats[r][c] = false; }
    public synchronized void confirmSeat(int r, int c) { seats[r][c] = true; }
}
