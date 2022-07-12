package com.ust.movie.backendMovies.model;

public class Movie {
    private int id;
    private String Title;
    private int Debut;
    private String Genre;
    private String Rating;
    private String Director;
    public Movie(){

    }
//Constructors
    public Movie(int id, String title, int debut, String genre, String rating, String director) {
        this.id = id;
        Title = title;
        Debut = debut;
        Genre = genre;
        Rating = rating;
        Director = director;
    }

    //getters/setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public int getDebut() {
        return Debut;
    }
    public void setDebut(int debut) {
        Debut = debut;
    }
    public String getGenre() {
        return Genre;
    }
    public void setGenre(String genre) {
        Genre = genre;
    }
    public String getRating() {
        return Rating;
    }
    public void setRating(String rating) {
        Rating = rating;
    }
    public String getDirector() {
        return Director;
    }
    public void setDirector(String director) {
        Director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", Debut=" + Debut +
                ", Genre='" + Genre + '\'' +
                ", Rating='" + Rating + '\'' +
                ", Director='" + Director + '\'' +
                '}';
    }
}
