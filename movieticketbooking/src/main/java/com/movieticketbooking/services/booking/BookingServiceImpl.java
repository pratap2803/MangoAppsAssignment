package com.movieticketbooking.services.booking;

import com.movieticketbooking.CustomException.SeatsUnavailableException;
import com.movieticketbooking.DTO.BookingRequestDTO;
import com.movieticketbooking.DTO.BookingResponseDTO;
import com.movieticketbooking.models.Booking;
import com.movieticketbooking.models.Show;
import com.movieticketbooking.models.User;
import com.movieticketbooking.repositories.BookingRepository;
import com.movieticketbooking.repositories.ShowRepository;
import com.movieticketbooking.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    @Override
//    @Transactional
    public BookingResponseDTO createBooking(BookingRequestDTO bookingRequestDTO) {

        if(!checkAvailabilityOfSeats(bookingRequestDTO.getNumberOfSeats(), bookingRequestDTO.getShowId())){
            // Retrieve user and show
            User user = userRepository.findById(bookingRequestDTO.getUserId())
                    .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + bookingRequestDTO.getUserId()));

            Show show = showRepository.findById(bookingRequestDTO.getShowId())
                    .orElseThrow(() -> new EntityNotFoundException("Show not found with id: " + bookingRequestDTO.getShowId()));

            // Create a new booking
            Booking booking = new Booking();
            booking.setUser(user);
            booking.setShow(show);
            booking.setNumberOfSeats(bookingRequestDTO.getNumberOfSeats());
            booking.setBookingTime(new Date());

            // Save booking
            Booking savedBooking = bookingRepository.save(booking);

            // Prepare response DTO
            BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
            bookingResponseDTO.setId(savedBooking.getId());
            bookingResponseDTO.setUserId(savedBooking.getUser().getId());
            bookingResponseDTO.setShow(savedBooking.getShow());


            return bookingResponseDTO;
        }else{
            throw new SeatsUnavailableException("Requested number of seats not available for show id: " + bookingRequestDTO.getShowId());
        }
    }

    private boolean checkAvailabilityOfSeats(Integer requestedNumberOfSeats, Long showId) {
        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isPresent()){
            Show show = optionalShow.get();
            if(requestedNumberOfSeats <= show.getAvailableSeats()){
                show.setAvailableSeats(show.getAvailableSeats() - requestedNumberOfSeats);
                showRepository.save(show);
                return true;
            }
        }

        return false;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<BookingResponseDTO> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(this::mapBookingToBookingResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponseDTO cancelBooking(Long bookingId) {
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
        if(optionalBooking.isPresent()){
            Booking deleteBooking = optionalBooking.get();
            markSeatsAsAvailable(deleteBooking.getNumberOfSeats(), deleteBooking.getShow());

            BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
            bookingResponseDTO.setId(deleteBooking.getId());
            bookingResponseDTO.setUserId(deleteBooking.getUser().getId());
            bookingResponseDTO.setShow(deleteBooking.getShow());

            bookingRepository.delete(deleteBooking);
            return bookingResponseDTO;
        }else{
            throw new EntityNotFoundException("Requested booking id doesn't exist" +  bookingId);
        }
    }

    private void markSeatsAsAvailable(Integer numberOfSeats, Show show) {
        show.setAvailableSeats(show.getAvailableSeats()+numberOfSeats);
        showRepository.save(show);
    }

    private BookingResponseDTO mapBookingToBookingResponseDTO(Booking booking) {
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        bookingResponseDTO.setId(booking.getId());
        bookingResponseDTO.setUserId(booking.getUser().getId());
        bookingResponseDTO.setShow(booking.getShow());
        return bookingResponseDTO;
    }

    // Add more methods as needed
}

