package com.movietracker.movie_tracker;

import org.springframework.stereotype.Service;

@Service
public class MovieUserService {
    // once it receives the object, they WON't be replaced
    private final TmdbService tmdbService;
    private final UserMovieService userMovieService;

    public MovieUserService(TmdbService tmdbService, UserMovieService userMovieService) {
        this.tmdbService = tmdbService;
        this.userMovieService = userMovieService;
    }

    public MovieWithUserStatus getMovieWithUserStatus(Long movieId) {
        Movie movie = tmdbService.getMovieDetails(movieId);
        UserMovie userMovie = userMovieService.getMovie(movieId);
        if (userMovie == null) {
            //creates temp placeholder for movies that are not in db
            userMovie = new UserMovie(movieId, false, false, false, false);     
        } 
        return new MovieWithUserStatus(movie, userMovie); // Create new MWUS object and put Movie obj and UserMovie                                                            // obj inside and return combined obj
    }
}
