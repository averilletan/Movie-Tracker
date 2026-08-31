package com.movietracker.movie_tracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
public class MovieUserController {
    private final MovieUserService movieUserService;
    private final RecommendationService recommendationService;

    public MovieUserController(MovieUserService movieUserService, RecommendationService recommendationService){
        this.movieUserService = movieUserService;
        this.recommendationService = recommendationService;
    }

    @GetMapping("/api/movies-status/{movieId}")
    public MovieWithUserStatus getMovieStatus(@PathVariable long movieId) {
        return movieUserService.getMovieWithUserStatus(movieId);
    }

    @GetMapping("/api/movies/movie-of-the-day")
    public Movie getMovieOfTheDay(){
        return movieUserService.getMovieOfTheDay();
    }

    @GetMapping("/api/movies/recommendations")
    public List<Movie> getRecommendations() {
        return recommendationService.getRecommendation();
    }

}
