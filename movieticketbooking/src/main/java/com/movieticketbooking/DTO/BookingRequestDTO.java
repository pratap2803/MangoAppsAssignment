package com.movieticketbooking.DTO;

import lombok.Data;

@Data
public class BookingRequestDTO {
    private Long userId;
    private Long showId;
    private Integer numberOfSeats;

    // Add constructors, getters, and setters
}
