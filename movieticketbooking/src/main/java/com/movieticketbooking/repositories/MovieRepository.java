package com.movieticketbooking.repositories;

import com.movieticketbooking.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
