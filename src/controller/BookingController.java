package com.example.movieticket.controller;

import com.example.movieticket.model.*;
import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private IBooking booking = new BookingProxy(); // proxy wraps BookingSystem

    public List<Show> searchShowsByGenre(String genre) {
        return BookingSystem.getInstance().searchShows(genre);
    }

    // Reserve and immediately confirm tickets (no payment step)
    public boolean reserveTickets(String username, Show show, List<int[]> seats) {
        // create tickets via prototype
        List<Ticket> tickets = new ArrayList<>();
        for (int[] s : seats) {
            Ticket template = new Ticket(show.getMovie().getTitle(), show, s[0], s[1], show.getPrice());
            tickets.add(template.cloneTicket());
        }
        boolean reserved = booking.reserveTempTickets(username, show, tickets);
        if (!reserved) return false;
        booking.confirmBooking(username, show, tickets);
        return true;
    }
}
