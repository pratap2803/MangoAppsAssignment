package com.movieticketbooking.services;

import com.movieticketbooking.DTO.ShowRequestDTO;
import com.movieticketbooking.models.Movie;
import com.movieticketbooking.models.Show;
import com.movieticketbooking.repositories.MovieRepository;
import com.movieticketbooking.repositories.ShowRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ShowService(ShowRepository showRepository, MovieRepository movieRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }

    public Show getShowById(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        return optionalShow.orElse(null);
    }

    public Show createShow(ShowRequestDTO showRequestDTO) {
        Long movieId = showRequestDTO.getMovieId();
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + movieId));

        Show show = new Show();
        show.setMovie(movie);
        show.setMovieTitle(showRequestDTO.getMovieTitle());
        show.setTheaterName(showRequestDTO.getTheaterName());
        show.setShowTime(new Date());
        show.setAvailableSeats(showRequestDTO.getAvailableSeats());

        return showRepository.save(show);
    }

    public Show updateShow(Long id, Show updatedShow) {
        Optional<Show> optionalShow = showRepository.findById(id);
        if (optionalShow.isPresent()) {
            Show existingShow = optionalShow.get();
            existingShow.setMovieTitle(updatedShow.getMovieTitle());
            existingShow.setTheaterName(updatedShow.getTheaterName());
            existingShow.setShowTime(updatedShow.getShowTime());
            existingShow.setMovie(updatedShow.getMovie());
            existingShow.setAvailableSeats(updatedShow.getAvailableSeats());
            return showRepository.save(existingShow);
        } else {
            return null;
        }
    }

    public boolean deleteShow(Long id) {
        Optional<Show> optionalShow = showRepository.findById(id);
        if (optionalShow.isPresent()) {
            showRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
