package com.example.movieticket.util;

import com.example.movieticket.model.*;
import java.util.*;

public class HardcodedData {
    public static List<Show> createSampleShows() {
        List<Show> s = new ArrayList<>();
        Movie m1 = MovieFactory.createMovie("Action", "Fast & Busy");
        Movie m2 = MovieFactory.createMovie("Comedy", "Fun Times");
        Show show1 = new ShowBuilder().setMovie(m1).setTheater(new Theater("Hall A")).setTime("18:00").setSeatLayout(5,4).setPrice(10.0).build();
        Show show2 = new ShowBuilder().setMovie(m2).setTheater(new Theater("Hall B")).setTime("20:00").setSeatLayout(5,4).setPrice(8.0).build();
        Movie m3 = MovieFactory.createMovie("Action", "Speed Rush");
        Movie m4 = MovieFactory.createMovie("Comedy", "Laugh Riot");
        Movie m5 = MovieFactory.createMovie("Action", "Chase Forever");
        Movie m6 = MovieFactory.createMovie("Comedy", "Office Antics");
        Show show3 = new ShowBuilder().setMovie(m3).setTheater(new Theater("Hall C")).setTime("16:00").setSeatLayout(6,5).setPrice(11.0).build();
        Show show4 = new ShowBuilder().setMovie(m4).setTheater(new Theater("Hall D")).setTime("21:00").setSeatLayout(5,5).setPrice(9.0).build();
        Show show5 = new ShowBuilder().setMovie(m5).setTheater(new Theater("Hall E")).setTime("19:30").setSeatLayout(4,4).setPrice(12.0).build();
        Show show6 = new ShowBuilder().setMovie(m6).setTheater(new Theater("Hall F")).setTime("22:00").setSeatLayout(5,4).setPrice(7.5).build();
        // preset some reserved seats
        show1.reserveSeat(0,0); // A1
        show1.reserveSeat(2,3);
        show2.reserveSeat(1,1);
        s.add(show1); s.add(show2); s.add(show3); s.add(show4); s.add(show5); s.add(show6);
        return s;
    }
}
