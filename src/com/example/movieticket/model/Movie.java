package com.example.movieticket.model;

public abstract class Movie {
    private final String title;
    private final String genre;

    protected Movie(String title, String genre) {
        this.title = title; this.genre = genre;
    }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
}
