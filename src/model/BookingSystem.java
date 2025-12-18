package model;

import util.HardcodedData;
import java.util.*;

public class BookingSystem implements IBooking {
    private static final BookingSystem INSTANCE = new BookingSystem();
    private final List<Show> shows = new ArrayList<>();

    private BookingSystem() {
        // populate initial shows (use HardcodedData)
        shows.addAll(HardcodedData.createSampleShows());
    }

    public static BookingSystem getInstance() {
        return INSTANCE;
    }

    public List<Show> searchShows(String genre) {
        List<Show> res = new ArrayList<>();
        for (Show s : shows) if (s.getMovie().getGenre().equalsIgnoreCase(genre)) res.add(s);
        return res;
    }

    @Override
    public synchronized boolean reserveTempTickets(String user, Show show, List<Ticket> tickets) {
        for (Ticket t : tickets) {
            if (!show.reserveSeat(t.getRow(), t.getCol())) {
                // rollback
                for (Ticket r : tickets) show.releaseSeat(r.getRow(), r.getCol());
                return false;
            }
        }
        System.out.println("Reserved temp tickets for " + user);
        return true;
    }

    @Override
    public synchronized void confirmBooking(String user, Show show, List<Ticket> tickets) {
        for (Ticket t : tickets) show.confirmSeat(t.getRow(), t.getCol());
        System.out.println("Confirmed booking for " + user + " - " + tickets.size() + " tickets");
    }

    @Override
    public synchronized void releaseReservedTickets(String user, Show show, List<Ticket> tickets) {
        for (Ticket t : tickets) show.releaseSeat(t.getRow(), t.getCol());
        System.out.println("Released reserved tickets for " + user);
    }
}
