package com.movieticketbooking.controllers;

import com.movieticketbooking.DTO.BookingRequestDTO;
import com.movieticketbooking.DTO.BookingResponseDTO;
import com.movieticketbooking.services.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingResponseDTO> createBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO responseDTO = bookingService.createBooking(bookingRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookingResponseDTO> cancelBooking(@PathVariable Long bookingId){
        BookingResponseDTO responseDTO = bookingService.cancelBooking(bookingId);

        if (responseDTO != null) {
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
        List<BookingResponseDTO> responseDTOs = bookingService.getAllBookings();
        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }

    // Additional endpoints as needed
}
