package com.movietracker.movie_tracker;

//Handles requests coming into your application.
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
//"Someone requested /api/movies. What should I run?"

@RestController // tells Spring Boot that this class is going to handle web request and return
                // responses

public class MovieController {
    private final TmdbService tmdbService;

    public MovieController(TmdbService tmdbService){
        this.tmdbService = tmdbService;
    } //Create MovieController then give me the TmdbService I NEED

    @GetMapping("/api/search/movies") // when someone sends a GET request to the /api/movies endpoint, this method will be called
    
    public MovieSearchResponse getMovie(@RequestParam String query) {
        return tmdbService.searchMovie(query); //TmdbService handle the movie, whatever gets back will be return to whoever called /api/movies
    }

    @GetMapping("/api/movies/{movieId}")
    public Movie getMovieDetails(@PathVariable long movieId){
        return tmdbService.getMovieDetails(movieId);
    }

    @GetMapping("/api/movies/trending")
    public MovieSearchResponse getTrendingMovies(){
        return tmdbService.getTrendingMovies();
    }
}
