package com.movietracker.movie_tracker;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecommendationService {
    private final UserMovieService userMovieService;
    private final TmdbService tmdbService;

    public RecommendationService(UserMovieService userMovieService, TmdbService tmdbService) {
        this.userMovieService = userMovieService;
        this.tmdbService = tmdbService;
    }

    public List<Movie> getRecommendation() {
        List<UserMovie> userMovies = userMovieService.getAllMovies();
        HashMap<Integer, Integer> genreScores = new HashMap<>();

        for (UserMovie userMovie : userMovies) {
            if (userMovie.isWatched() || userMovie.isFavourite()) {
                Movie movie = tmdbService.getMovieDetails(userMovie.getMovieId());
                List<Genre> genres = movie.getGenres();
                for (Genre genre : genres) { // another loop to loop the genres of the movie
                    Integer genreId = genre.getGenreId();
                    int score = userMovie.isFavourite() ? 3 : 1;
                    genreScores.put(genreId, genreScores.getOrDefault(genreId, 0) + score);
                }
            }
        }
        int highest = 0;
        int highestGenreId = 0;
        for (Map.Entry<Integer, Integer> entry : genreScores.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > highest) {
                highest = value;
                highestGenreId = key;
            }
        }
        MovieSearchResponse recommendation = tmdbService.discoverMoviesByGenre(highestGenreId);
        return recommendation.getResults();
    }
}
