package com.movietracker.movie_tracker;

import org.springframework.stereotype.Service;

@Service
public class UserMovieService {
    private final UserMovieRepository userMovieRepository;

    public UserMovieService(UserMovieRepository userMovieRepository){
        this.userMovieRepository = userMovieRepository;
    }

    public UserMovie saveMovie(UserMovie userMovie){
        return userMovieRepository.save(userMovie);
    }

    public UserMovie getMovie(Long movieId){
        return userMovieRepository.findById(movieId).orElse(null);
    }

    //PUT is to change/update db
    public UserMovie updateMovie(Long movieId, UserMovie userMovie){
        UserMovie existingMovie = userMovieRepository.findById(movieId).orElseThrow();

        existingMovie.setWatched(userMovie.isWatched());
        existingMovie.setWatching(userMovie.isWatching());
        existingMovie.setWatchlist(userMovie.isWatchlist());
        existingMovie.setFavourite(userMovie.isFavourite());

        return userMovieRepository.save(existingMovie);
    }

    public void deleteMovie(Long movieId){
        userMovieRepository.deleteById(movieId);
    }
}
