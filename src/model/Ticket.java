package model;

public class Ticket implements Cloneable {
    private final String movieTitle;
    private final Show show;
    private final int row, col;
    private final double price;
    private String status = "TEMP";

    public Ticket(String movieTitle, Show show, int row, int col, double price) {
        this.movieTitle = movieTitle; this.show = show; this.row = row; this.col = col; this.price = price;
    }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public Show getShow() { return show; }
    public void setStatus(String s) { status = s; }
    public String getStatus() { return status; }
    public Ticket cloneTicket() {
        try { return (Ticket) this.clone(); } catch (CloneNotSupportedException e) { return new Ticket(movieTitle, show, row, col, price); }
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String toString() { return movieTitle + " [" + row + "," + col + "] " + status; }
}
