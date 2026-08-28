package com.movietracker.movie_tracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long>{
    
}
