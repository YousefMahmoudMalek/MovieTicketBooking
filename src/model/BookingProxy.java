package model;

import java.util.List;

public class BookingProxy implements IBooking {
    private final BookingSystem real = BookingSystem.getInstance();

    @Override
    public boolean reserveTempTickets(String user, Show show, List<Ticket> tickets) {
        if (!SessionManager.getInstance().isAuthenticated(user)) {
            System.out.println("Proxy: user not authenticated: " + user);
            return false;
        }
        return real.reserveTempTickets(user, show, tickets);
    }

    @Override
    public void confirmBooking(String user, Show show, List<Ticket> tickets) {
        if (!SessionManager.getInstance().isAuthenticated(user)) {
            System.out.println("Proxy: cannot confirm, user not authenticated: " + user);
            return;
        }
        real.confirmBooking(user, show, tickets);
    }

    @Override
    public void releaseReservedTickets(String user, Show show, List<Ticket> tickets) {
        real.releaseReservedTickets(user, show, tickets);
    }
}
