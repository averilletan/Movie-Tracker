package com.movietracker.movie_tracker;
//Handles requests coming into your application.
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //tells Spring Boot that this class is going to handle web request and return responses
public class MovieController {
    @GetMapping("/api/movies") //when someone sends a GET request to the /api/movies endpoint, this method will be called
    public String getMovies() {
        return "Movie Tracker API is working!"; //run this method and send this text back
    }   
}
