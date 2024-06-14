package com.movieticketbooking.services;

import com.movieticketbooking.models.Movie;
import com.movieticketbooking.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie createMovie(Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();
            existingMovie.setTitle(updatedMovie.getTitle());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setDuration(updatedMovie.getDuration());
            existingMovie.setLanguage(updatedMovie.getLanguage());
            existingMovie.setReleaseDate(updatedMovie.getReleaseDate());

            return movieRepository.save(existingMovie);
        } else {
            return null;
        }
    }

    public boolean deleteMovie(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            Movie existingMovie = optionalMovie.get();
            movieRepository.delete(existingMovie);
            return true;
        }else{
            return false;
        }
    }

    // Other service methods as needed
}