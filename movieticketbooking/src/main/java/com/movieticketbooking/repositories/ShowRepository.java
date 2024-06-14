package com.movieticketbooking.repositories;

import com.movieticketbooking.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovieTitle(String movieTitle);
    List<Show> findByTheaterName(String theaterName);
}
