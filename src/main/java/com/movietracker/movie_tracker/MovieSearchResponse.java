package com.movietracker.movie_tracker;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieSearchResponse {
    private int page;
    private List<Movie> results;
    @JsonProperty("total_pages")
    private int totalPages;
    @JsonProperty("total_results")
    private int totalResults;

    public MovieSearchResponse(int page, List<Movie> results, int totalPages, int totalResults){
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
        this.totalResults = totalResults;
    }

    public int getPage(){
        return page;
    }

    public List<Movie> getResults(){
        return results;
    }

    public int getTotalPages(){
        return totalPages;
    }

    public int getTotalResults(){
        return totalResults;
    }

}
