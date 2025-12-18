package model;

import movieTypes.ActionMovie;
import movieTypes.ComedyMovie;

public class MovieFactory {
    public static Movie createMovie(String genre, String title) {
        switch (genre.toLowerCase()) {
            case "action": return new ActionMovie(title);
            case "comedy": return new ComedyMovie(title);
            default: return new ActionMovie(title);
        }
    }
}
