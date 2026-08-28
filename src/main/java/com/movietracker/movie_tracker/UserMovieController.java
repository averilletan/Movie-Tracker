package com.movietracker.movie_tracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class UserMovieController {

    private final UserMovieService userMovieService;

    public UserMovieController(UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
    }

    @PostMapping("/api/user-movies")
    public UserMovie saveMovie(@RequestBody UserMovie userMovie){
        return userMovieService.saveMovie(userMovie);
    }

    @GetMapping("/api/user-movies/{movieId}")
    public UserMovie getMovie(@PathVariable Long movieId){
        return userMovieService.getMovie(movieId);
    }

    @PutMapping("/api/user-movies/{movieId}")
    public UserMovie updateMovie(@PathVariable Long movieId, @RequestBody UserMovie userMovie){
        return userMovieService.updateMovie(movieId, userMovie);
    }

    @DeleteMapping("/api/user-movies/{movieId}")
    public void deleteMovie(@PathVariable Long movieId){
        userMovieService.deleteMovie(movieId);
    }

}
