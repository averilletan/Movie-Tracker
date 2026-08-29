package com.movietracker.movie_tracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MovieUserController {
    private final MovieUserService movieUserService;

    public MovieUserController(MovieUserService movieUserService){
        this.movieUserService = movieUserService;
    }

    @GetMapping("/api/movies-status/{movieId}")
    public MovieWithUserStatus getMovieStatus(@PathVariable long movieId) {
        return movieUserService.getMovieWithUserStatus(movieId);
    }

}
