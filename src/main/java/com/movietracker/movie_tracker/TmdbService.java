package com.movietracker.movie_tracker;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service //tells Spring Boot that this class is a service component that it needs to manage, use this when mMovieController.java needs to talk to TmdbService.java, so that it can get the data from the API and send it back to the controller, which will then send it back to the client.
public class TmdbService {
    //Every TmdbService object will have its own RestClient object, which will be used to make HTTP requests to the TMDB API. 
    //(DA Phonebook analogy: RestClient is like a phone that TmdbService uses to call the TMDB API and get information about movies.)
    private final RestClient restClient;

    public TmdbService(RestClient restClient){
        this.restClient = restClient;
    }

    public MovieSearchResponse searchMovie(String query){
        return restClient.get()
        .uri("/search/movie?query=" + query)
        .retrieve()
        .body(MovieSearchResponse.class);
    }

    public Movie getMovieDetails(Long movieId){
        return restClient.get()
        .uri("/movie/" + movieId)
        .retrieve().body(Movie.class);
    }

}
