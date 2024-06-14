package com.movieticketbooking.DTO;

import com.movieticketbooking.models.Show;
import lombok.Data;

@Data
public class BookingResponseDTO {
    private Long id;
    private Long userId;
    private Show show;
}
