package com.movietracker.movie_tracker;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {
    @JsonProperty("id")
    private int genreId;
    @JsonProperty("name")
    private String genreName;

    public Genre(int genreId, String genreName){
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public int getGenreId(){
        return genreId;
    }

    public String getGenreName(){
        return genreName;
    }
    
}
