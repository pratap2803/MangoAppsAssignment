package com.movieticketbooking.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowRequestDTO {
    private String movieTitle;
    private LocalDateTime showTime;
    private String theaterName;
    private Long movieId;
    private Long availableSeats;
}