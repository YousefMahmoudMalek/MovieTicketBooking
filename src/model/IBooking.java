package com.example.movieticket.model;

import java.util.List;

public interface IBooking {
    boolean reserveTempTickets(String user, Show show, List<Ticket> tickets);
    void confirmBooking(String user, Show show, List<Ticket> tickets);
    void releaseReservedTickets(String user, Show show, List<Ticket> tickets);
}
