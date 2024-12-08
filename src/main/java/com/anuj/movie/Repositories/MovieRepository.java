package com.anuj.movie.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.movie.Entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
    Movie findByMovieName(String name);
}
