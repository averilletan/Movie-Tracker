package com.movietracker.movie_tracker;

public class MovieWithUserStatus {
    
    private Movie movie; //object that hold Movie object
    private UserMovie userMovie; //object that holds UserMovie object

    public MovieWithUserStatus(Movie movie, UserMovie userMovie){
        this.movie = movie; //Take the Movie object that was passed in and store it in this object's movie field.
        this.userMovie = userMovie;
    }

    public Movie getMovie(){
        return movie;
    }

    public UserMovie getUserMovie(){
        return userMovie;
    }
}
