package com.movietracker.movie_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserMovie {
    @Id
    private Long movieId;
    private boolean isWatched;
    private boolean isWatching;
    private boolean isWatchlist;
    private boolean isFavourite;

    public UserMovie(Long movieId, boolean isWatched, boolean isWatching, boolean isWatchlist, boolean isFavourite) {
        this.movieId = movieId;
        this.isWatched = isWatched;
        this.isWatching = isWatching;
        this.isWatchlist = isWatchlist;
        this.isFavourite = isFavourite;
    }

    public UserMovie() {

    }

    public Long getMovieId() {
        return movieId;
    }

    public boolean isWatched() {
        return isWatched;
    }

    public boolean isWatching() {
        return isWatching;
    }

    public boolean isWatchlist() {
        return isWatchlist;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setWatched(boolean watched) {
        this.isWatched = watched;
    }

    public void setWatching(boolean watching) {
        this.isWatching = watching;
    }

    public void setWatchlist(boolean watchlist) {
        this.isWatchlist = watchlist;
    }

    public void setFavourite(boolean favourite) {
        this.isFavourite = favourite;
    }
}
