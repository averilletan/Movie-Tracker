package com.movietracker.movie_tracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.beans.factory.annotation.Value;

@Configuration //"Spring, this class contains instructions for creating things."
public class TmdbConfig {

    @Value("${tmdb.api.token}")
    private String tmdbApiToken;

    @Bean //Hey Spring, I want you to create this object and keep it available so other parts of the application can use it
    public RestClient restClient(){
        return RestClient.builder()
        .baseUrl("https://api.themoviedb.org/3")
        .defaultHeader("Authorization", "Bearer " + tmdbApiToken) //when called, automatically attach this information
        .build(); //creates the RestClient object to make HTTP requests later (Phone)
    }
}
