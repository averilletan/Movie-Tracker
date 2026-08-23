package com.movietracker.movie_tracker;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


//This Movie class represents a movie entity with its attributes such as id, title, description, release date, and rating.
//So we can have movie 1 with these attributes, movie 2 with another set of its own attributes, and so on. 
//This class can be used to create movie objects and store their information in a structured way.
//Blueprint for the Movie class
public class Movie {
    private Long id;
    private String title;
    @JsonProperty("overview")
    private String description;
    //private String genre;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("vote_average")
    private double rating;    

    public Movie(Long id, String title, String description, List<Integer> genreIds, LocalDate releaseDate, double rating){
        //this.title: Movie object's field
        //title parameter: value passed to the constructor
        //Take the title that was passed into the constructor and store in Movie's object's title field
        this.id = id;
        this.title = title;
        this.description = description;
        this.genreIds = genreIds;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    public Long getId(){
        return id;      
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }   

    public List<Integer> getGenreIds(){
        return genreIds;
    }

    public LocalDate getReleaseDate(){
        return releaseDate;
    }

    public double getRating(){
        return rating;
    }

}
