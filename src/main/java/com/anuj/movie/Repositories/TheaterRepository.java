package com.anuj.movie.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.movie.Entities.Theater;


public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);
}
