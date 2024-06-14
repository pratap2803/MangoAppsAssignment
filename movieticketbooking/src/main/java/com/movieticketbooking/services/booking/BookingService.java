package com.movieticketbooking.services.booking;

import com.movieticketbooking.DTO.BookingRequestDTO;
import com.movieticketbooking.DTO.BookingResponseDTO;

import java.util.List;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO);
    List<BookingResponseDTO> getAllBookings();
    BookingResponseDTO cancelBooking(Long bookingId);
}
